package com.riwi.techq.Application.Services;

import com.riwi.techq.Application.Ports.in.IUserService;
import com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto.UserRequestDto;
import com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto.UserResponseDto;
import com.riwi.techq.Infrastructure.Adapters.Out.Persistence.UserRepository;
import com.riwi.techq.domain.Excepcions.ResourceNotFoundException;
import com.riwi.techq.domain.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
     private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDto register(UserRequestDto userRequest) {
        // buscamos usuario por username
        if (userRepository.findByEmail(userRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        // encriptamos la password

        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        return null;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }




    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
