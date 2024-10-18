package com.riwi.techq.Application.Ports.in;
import com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto.UserRequestDto;
import com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto.UserResponseDto;
import com.riwi.techq.Infrastructure.Adapters.Out.Persistence.UserRepository;
import com.riwi.techq.domain.Model.User;

import java.util.List;

public interface IUserService {

    public UserResponseDto register(UserRequestDto userRequestDto);
    public List<User> findAll();
    public User findById(Long id);
}
