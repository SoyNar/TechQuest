package com.riwi.techq.Missions.Application.Service;

import com.riwi.techq.Missions.Application.Dtos.Request.MissionRequestDto;
import com.riwi.techq.Missions.Application.Dtos.Response.MissionResponseDto;

public interface IMissionService{

    public MissionResponseDto createMission (MissionRequestDto requestDto);
}
