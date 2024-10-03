package com.riwi.techq.Application.Services;

import com.riwi.techq.Application.Ports.in.IUserService;
import com.riwi.techq.Infrastructure.Adapters.Out.Persistence.UserRepository;
import com.riwi.techq.domain.Excepcions.ResourceNotFoundException;
import com.riwi.techq.domain.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
     private UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findByEmail(User user) {
        return this.userRepository.findByEmail(user.getEmail());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
