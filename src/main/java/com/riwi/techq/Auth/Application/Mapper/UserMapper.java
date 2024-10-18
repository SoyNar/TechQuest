package com.riwi.techq.Auth.Application.Mapper;


import com.riwi.techq.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techq.Auth.Application.Dtos.UserResponseDto;
import com.riwi.techq.Auth.Domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapear desde RequestUserDto a User (entrada)
    User requestUserDtoToUser(UserRequestDto requestUserDto);

    //Mapear desde User a ResponseUserDto (salida)
    @Mapping(target = "role", source = "role.name") // El rol se mapea como String
    UserResponseDto userToResponseUserDto(User user);

}
