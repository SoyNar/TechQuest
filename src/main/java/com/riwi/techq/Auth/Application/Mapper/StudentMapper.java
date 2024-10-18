package com.riwi.techquesproject.Auth.Application.Mapper;

import com.riwi.techquesproject.Auth.Application.Dtos.StudentResponseDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserResponseDto;
import com.riwi.techquesproject.Auth.Domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    // Mapear desde RequestUserDto a User (entrada)
    User requestUserDtoToUser(UserRequestDto requestUserDto);

    //Mapear desde USer a ResponseStudentDto (salida)

    StudentResponseDto studentToResponseUserDto(User user);
}
