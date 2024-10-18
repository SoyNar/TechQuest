package com.riwi.techq.Skills.Application.Dtos.Response;

import com.riwi.techq.Skills.Domain.SkillType;
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
