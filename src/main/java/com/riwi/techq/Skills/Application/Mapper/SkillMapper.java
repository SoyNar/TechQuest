package com.riwi.techquesproject.Skills.Application.Mapper;

import com.riwi.techquesproject.Auth.Application.Dtos.UserRequestDto;
import com.riwi.techquesproject.Auth.Application.Dtos.UserResponseDto;
import com.riwi.techquesproject.Auth.Domain.User;
import com.riwi.techquesproject.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techquesproject.Skills.Application.Dtos.Resquest.SkillRequestDto;
import com.riwi.techquesproject.Skills.Domain.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);
    // Mapear desde SkillRequestDto a skill (entrada)
    Skills requestSkillDtoToSkills(SkillRequestDto requestDto);

    //Mapear desde Skills a SkillResponseDto (salida)

    SkillResponseDto skillsToResponseSkillDto(Skills skills);
}
