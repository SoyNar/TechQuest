package com.riwi.techq.Auth.Application.Mapper;

import com.riwi.techq.Auth.Application.Dtos.StudentResponseDto;
import com.riwi.techq.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techq.Auth.Domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T09:45:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Ubuntu)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public User requestUserDtoToUser(UserRequestDto requestUserDto) {
        if ( requestUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setFullname( requestUserDto.getFullname() );
        user.setUsername( requestUserDto.getUsername() );
        user.setPassword( requestUserDto.getPassword() );

        return user;
    }

    @Override
    public StudentResponseDto studentToResponseUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        return studentResponseDto;
    }
}
