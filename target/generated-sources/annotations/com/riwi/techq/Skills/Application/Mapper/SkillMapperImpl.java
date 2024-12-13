package com.riwi.techq.Skills.Application.Mapper;

import com.riwi.techq.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techq.Skills.Application.Dtos.Resquest.SkillRequestDto;
import com.riwi.techq.Skills.Domain.Skills;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T09:45:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Ubuntu)"
)
public class SkillMapperImpl implements SkillMapper {

    @Override
    public Skills requestSkillDtoToSkills(SkillRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Skills skills = new Skills();

        return skills;
    }

    @Override
    public SkillResponseDto skillsToResponseSkillDto(Skills skills) {
        if ( skills == null ) {
            return null;
        }

        SkillResponseDto skillResponseDto = new SkillResponseDto();

        return skillResponseDto;
    }
}
