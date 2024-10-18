package com.riwi.techquesproject.Auth.Application.Controllers;

import com.riwi.techquesproject.Auth.Application.Dtos.StudentResponseDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserResponseDto;
import com.riwi.techquesproject.Auth.Application.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    // solo para administradora
    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createStudent(UserRequestDto userRequest){
        UserResponseDto userResponse = this.userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    // publico
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(UserRequestDto userRequest){
        UserResponseDto userResponse = this.userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    // solo para administradora
    @PutMapping("/status/{username}")
    public ResponseEntity<UserResponseDto> changeUserStatus(@PathVariable String username){
        UserResponseDto userResponseDto = this.userService.updateUser(username);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    // para administradoras, estudiantes active true
    @GetMapping("/student")
    public ResponseEntity<List<UserResponseDto>> getStudentActive(){
        List<UserResponseDto> studentActive = this.userService.StudentActiveTrue();
        return ResponseEntity.status(HttpStatus.OK).body(studentActive);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<UserResponseDto> getStudentById(@PathVariable int id){
        UserResponseDto userResponseDto = this.userService.findStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @GetMapping("/student/{username}")
    public ResponseEntity<UserResponseDto> getStudentByUsername(@PathVariable String username){
        UserResponseDto userResponseDto = this.userService.findStudentByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    // metodo para asignar habilidades a un estudiante
    @PostMapping("/{id}/abilities")
    public ResponseEntity<StudentResponseDto> assignAbilities(@PathVariable String username, @RequestBody List<String> skillNames) {
        StudentResponseDto responseStudent = userService.assingedSkillToUser(username, skillNames);
        return ResponseEntity.ok(responseStudent);
    }
}
