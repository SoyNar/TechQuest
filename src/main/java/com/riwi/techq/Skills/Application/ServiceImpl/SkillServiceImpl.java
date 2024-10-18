package com.riwi.techq.Skills.Application.ServiceImpl;

import com.riwi.techq.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techq.Skills.Application.Dtos.Resquest.SkillRequestDto;
import com.riwi.techq.Skills.Application.IService.ISkillService;
import com.riwi.techq.Skills.Application.Mapper.SkillMapper;
import com.riwi.techq.Skills.Domain.Skills;
import com.riwi.techq.Skills.Infrastructure.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements ISkillService {

    @Autowired
     private ISkillRepository skillRepository;
    @Autowired
    private SkillMapper skillMapper;

    //crear una habilidad  solo teacher o admin

    @Override
    public SkillResponseDto createSkill(SkillRequestDto skillRequestDto) {
        // validar si ya existe un skill con ese nombre
        Skills skills = this.skillRepository.findByName(skillRequestDto.getTitle())
                .orElseThrow(()-> new IllegalArgumentException("this skill aready exist"));

        // Mapear el DTO a la entidad skill
        Skills skillsEntity  =skillMapper.requestSkillDtoToSkills(skillRequestDto);

        // guardar la nueva skill
        Skills saveSkill = skillRepository.save(skillsEntity);
        return skillMapper.skillsToResponseSkillDto(saveSkill);
    }
}
