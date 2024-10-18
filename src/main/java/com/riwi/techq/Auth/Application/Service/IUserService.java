package com.riwi.techq.Auth.Application.Service;



import com.riwi.techq.Auth.Application.Dtos.StudentResponseDto;
import com.riwi.techq.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techq.Auth.Application.Dtos.UserResponseDto;

import java.util.List;

public interface IUserService {
    public UserResponseDto register (UserRequestDto userRequestDto);
    public UserResponseDto createUser (UserRequestDto userRequestDto);
    public UserResponseDto updateUser (String username);
    public List<UserResponseDto> StudentActiveTrue();
    public UserResponseDto findStudentById(int id);
    UserResponseDto findStudentByUsername(String username);
    StudentResponseDto assingedSkillToUser (String username, List<String> skillName);

}
