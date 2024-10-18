package com.riwi.techquesproject.Skills.Application.IService;

import com.riwi.techquesproject.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techquesproject.Skills.Application.Dtos.Resquest.SkillRequestDto;

public interface ISkillService {
    public SkillResponseDto createSkill(SkillRequestDto skillRequestDto);
}
