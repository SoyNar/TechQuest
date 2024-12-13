package com.riwi.techq.Auth.Application.Dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private  String username;
    private  String roleName;
    private String fullname;
}
