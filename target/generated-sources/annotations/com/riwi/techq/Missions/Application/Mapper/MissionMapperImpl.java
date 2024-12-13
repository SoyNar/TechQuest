package com.riwi.techq.Missions.Application.Mapper;

import com.riwi.techq.Missions.Application.Dtos.Response.MissionResponseDto;
import com.riwi.techq.Missions.Domain.Mission;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T09:45:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Ubuntu)"
)
public class MissionMapperImpl implements MissionMapper {

    @Override
    public MissionResponseDto missionToResponseMissionDto(Mission mission) {
        if ( mission == null ) {
            return null;
        }

        MissionResponseDto missionResponseDto = new MissionResponseDto();

        return missionResponseDto;
    }
}
