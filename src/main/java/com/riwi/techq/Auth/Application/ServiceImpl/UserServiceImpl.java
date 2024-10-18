package com.riwi.techq.Auth.Application.ServiceImpl;


import com.riwi.techq.Auth.Application.Dtos.StudentResponseDto;
import com.riwi.techq.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techq.Auth.Application.Dtos.UserResponseDto;
import com.riwi.techq.Auth.Application.Mapper.StudentMapper;
import com.riwi.techq.Auth.Application.Mapper.UserMapper;
import com.riwi.techq.Auth.Application.Service.IUserService;
import com.riwi.techq.Auth.Domain.Role;
import com.riwi.techq.Auth.Domain.User;
import com.riwi.techq.Auth.infrastructure.Persistence.IUserRepository;
import com.riwi.techq.Skills.Domain.Skills;
import com.riwi.techq.Skills.Infrastructure.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
     private IUserRepository userRepository;
    @Autowired
     private UserMapper userMapper;

    @Autowired
    private ISkillRepository skillRepository;
    @Autowired
    private StudentMapper studentMapper;

    // este es para será un metodo publico
    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) {
        // buscados usuario por usernama
        if (userRepository.findByUsername(userRequestDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        // Mapear el DTO a la entidad User
        User user = userMapper.requestUserDtoToUser(userRequestDto);

        user.setActive(true);

        // encriptar contraseña
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Guardar el nuevo usuario en la base de datos
        User savedUser = userRepository.save(user);
        // devolver un user responser con mapper
        return userMapper.userToResponseUserDto(savedUser);
    }
// solo para administradoras
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        // se busca el usuario por username para verificar que no exista en la base de datos
        Optional<User> existingUser = this.userRepository.findByUsername(userRequestDto.getUsername());
        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        // Mapear el DTO a la entidad User
        User user = userMapper.requestUserDtoToUser(userRequestDto);
        // Asignar el rol de estudiante
        user.setRole(Role.STUDENT);

        // active true
        user.setActive(true);
        // encriptar contraseña
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Guardar el nuevo usuario en la base de datos
        User savedUser = userRepository.save(user);
        // devolver un user responser con mapper
        return userMapper.userToResponseUserDto(savedUser);
    }
// cambiar estado de estudiante
    @Override
    public UserResponseDto updateUser(String username) {
        UserRequestDto userRequestDto = new UserRequestDto();
        Optional<User> existingUser = this.userRepository.findByUsername(username);
        if(existingUser.isEmpty()) {
            throw new IllegalArgumentException("Username does not exist");
        }
        // Obtener el usuario
        User user = existingUser.get();

        // Cambiar el estado 'active' al contrario de lo que tenga actualmente
        user.setActive(!user.isActive());
        // guardar el nuevo estado del usuario
        User updatedUser = userRepository.save(user);

        // retornar el userREsponse con mapper
        return userMapper.userToResponseUserDto(updatedUser);
    }

    // obtener estudiantes activos
    // solo administradora
    @Override
    public List<UserResponseDto> StudentActiveTrue() {

            // Obtener todos los usuarios cuyo role sea 'STUDENT' y cuyo active sea 'true'
            List<User> activeStudents = userRepository.findByRoleAndActive(Role.STUDENT, true);

            // Mapear la lista de User a ResponseUserDto
            return activeStudents.stream()
                    .map(userMapper::userToResponseUserDto)
                    .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findStudentById(int id) {
       User  findStudentId = this.userRepository.findById(id).orElseThrow(() ->
       new IllegalArgumentException("User not Found"));

        return userMapper.userToResponseUserDto(findStudentId);
    }

    @Override
    public UserResponseDto findStudentByUsername(String username) {
        User findStudenUsername = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found" + username));
        return userMapper.userToResponseUserDto(findStudenUsername);
    }

    // asignar habilidades a un estudiante
    @Override
    public StudentResponseDto assingedSkillToUser(String username, List<String> skillName) {
      // buscar estudiante por username
        User userAsigned = this.userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("USer name not found " + username));

// validar el rol de estudiante
        if (userAsigned.getRole() != Role.STUDENT) {
            throw new RuntimeException("Only users with role STUDENT can be assigned skills.");
        }
        //buscar skils por nombre
       List<Skills> SkillsToAsigned = skillRepository.findByNameIn(skillName);
// si las skills no existen no se podran asignar
        if (SkillsToAsigned.isEmpty()) {
            throw new RuntimeException("No valid skills found");
        }

        // asignar las habilidades al estudiantes
        userAsigned.getUserSkill().addAll(SkillsToAsigned);

        // guardar en la base de datos
        userRepository.save(userAsigned);

        StudentResponseDto responseStudent = studentMapper.INSTANCE.studentToResponseUserDto(userAsigned);

        return responseStudent;
    }


}
