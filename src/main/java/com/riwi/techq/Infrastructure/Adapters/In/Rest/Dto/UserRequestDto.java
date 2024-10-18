package com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = " username no puede estar vacio")
    private String username;
    @NotBlank(message = " password no puede estar vacio")
    private String password;
}
