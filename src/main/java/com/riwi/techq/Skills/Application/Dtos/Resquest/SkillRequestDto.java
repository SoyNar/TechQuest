package com.riwi.techquesproject.Skills.Application.Dtos.Resquest;

import com.riwi.techquesproject.Skills.Domain.SkillType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequestDto {
    @NotBlank(message = "no puede ser null")
    private  String title;
    @NotNull(message = "no puede ser null")
    private SkillType skillType;
}
