package com.riwi.techquesproject.Skills.Application.Dtos.Response;

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
public class SkillResponseDto {


    private  String title;
    private SkillType skillType;
}
