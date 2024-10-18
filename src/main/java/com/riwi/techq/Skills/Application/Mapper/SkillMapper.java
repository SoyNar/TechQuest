package com.riwi.techq.Skills.Application.Mapper;

import com.riwi.techq.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techq.Skills.Application.Dtos.Resquest.SkillRequestDto;
import com.riwi.techq.Skills.Domain.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);
    // Mapear desde SkillRequestDto a skill (entrada)
    Skills requestSkillDtoToSkills(SkillRequestDto requestDto);

    //Mapear desde Skills a SkillResponseDto (salida)

    SkillResponseDto skillsToResponseSkillDto(Skills skills);
}
