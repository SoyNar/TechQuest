package com.riwi.techq.Missions.Application.Mapper;


import com.riwi.techq.Missions.Application.Dtos.Request.MissionRequestDto;
import com.riwi.techq.Missions.Application.Dtos.Response.MissionResponseDto;
import com.riwi.techq.Missions.Domain.Mission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MissionMapper {
    MissionMapper INSTANCE = Mappers.getMapper(MissionMapper.class);
    // Mapear desde RequestUserDto a User (entrada)
    MissionMapper requestMissionDtoToUser(MissionRequestDto missionRequestDto);

    //Mapear desde USer a ResponseStudentDto (salida)

    MissionResponseDto missionToResponseMissionDto(Mission mission);
}
