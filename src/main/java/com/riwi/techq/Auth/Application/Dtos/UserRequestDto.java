package com.riwi.techq.Auth.Application.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank(message = " fullname no puede estar vacio")
    private String fullname;
    @NotBlank(message = " username no puede estar vacio")
    private String username;
    @NotBlank(message = " password no puede estar vacio")
    private String password;

    public @NotBlank(message = " fullname no puede estar vacio") String getFullname() {
        return fullname;
    }

    public void setFullname(@NotBlank(message = " fullname no puede estar vacio") String fullname) {
        this.fullname = fullname;
    }

    public @NotBlank(message = " username no puede estar vacio") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = " username no puede estar vacio") String username) {
        this.username = username;
    }

    public @NotBlank(message = " password no puede estar vacio") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = " password no puede estar vacio") String password) {
        this.password = password;
    }
}
