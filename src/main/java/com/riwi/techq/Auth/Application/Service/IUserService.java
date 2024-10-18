package com.riwi.techquesproject.Auth.Application.Service;

import com.riwi.techquesproject.Auth.Application.Dtos.StudentResponseDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserResponseDto;
import com.riwi.techquesproject.Skills.Domain.Skills;

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
