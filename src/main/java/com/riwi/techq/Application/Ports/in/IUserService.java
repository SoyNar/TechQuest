package com.riwi.techq.Application.Ports.in;

import com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto.AuthRequest;
import com.riwi.techq.domain.Model.User;

import java.util.List;

public interface IUserService {

    public User save(User user);
    public List<User> findAll();
    public  User findByEmail(User user);
    public User findById(Long id);
}
