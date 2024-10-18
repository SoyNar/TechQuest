package com.riwi.techq.Missions.Application.ServiceImpl;

import com.riwi.techq.Auth.Domain.User;
import com.riwi.techq.Auth.infrastructure.Persistence.IUserRepository;
import com.riwi.techq.Missions.Application.Dtos.Request.MissionRequestDto;
import com.riwi.techq.Missions.Application.Dtos.Response.MissionResponseDto;
import com.riwi.techq.Missions.Application.Mapper.MissionMapper;
import com.riwi.techq.Missions.Application.Service.IMissionService;
import com.riwi.techq.Missions.Domain.Mission;
import com.riwi.techq.Missions.Infrastructure.IMissionRepository;
import com.riwi.techq.Skills.Domain.Skills;
import com.riwi.techq.Skills.Infrastructure.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissionServiceImpl  implements IMissionService {

    @Autowired
    private IMissionRepository missionRepository;
    @Autowired
    private ISkillRepository skillRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private MissionMapper missionMapper;
    @Override
    public MissionResponseDto createMission(MissionRequestDto requestDto) {
// crear una mission

        Mission mission = Mission.builder()
                .name(requestDto.getName())
                .build();

        // validar y asignar habilidades requeridas
        List<Skills> requiredSkills = skillRepository.findByNameIn(requestDto.getSkillsName());
        if (requiredSkills.isEmpty()) {
            throw new RuntimeException("No valid skills found");
        }
        mission.setMissionSkill(requiredSkills);


        // Validar y asignar los estudiantes
        List<User> assignedStudents = new ArrayList<>();
        for (String studentname : requestDto.getNameStudent()) {
            User student = userRepository.findByUsername(studentname)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            // Validar que el estudiante tenga las habilidades necesarias
            if (!student.getUserSkill().containsAll(requiredSkills)) {
                throw new RuntimeException("Student " + student.getFullname() + " lacks required skills");
            }

            assignedStudents.add(student);
        }
        mission.setUserMission(assignedStudents);


        // Guardar la misión en la base de datos
        mission = missionRepository.save(mission);

        // Convertir a MissionResponseDto con el mapper



        return missionMapper.missionToResponseMissionDto(mission);
    }
}
