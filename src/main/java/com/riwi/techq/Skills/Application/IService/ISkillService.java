package com.riwi.techq.Skills.Application.IService;


import com.riwi.techq.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techq.Skills.Application.Dtos.Resquest.SkillRequestDto;

public interface ISkillService {
    public SkillResponseDto createSkill(SkillRequestDto skillRequestDto);
}
