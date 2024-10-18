package com.riwi.techq.Missions.Application.Controllers;

import com.riwi.techq.Missions.Application.Dtos.Request.MissionRequestDto;
import com.riwi.techq.Missions.Application.Dtos.Response.MissionResponseDto;
import com.riwi.techq.Missions.Application.Service.IMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
public class MissionController {
    @Autowired
     private  IMissionService missionService;

    @PostMapping("/create")
    public ResponseEntity<MissionResponseDto> createMissionOne (MissionRequestDto requestDtoMission){
        MissionResponseDto missionResponseDto = this.missionService.createMission(requestDtoMission);
        return ResponseEntity.status(HttpStatus.CREATED).body(missionResponseDto);

    }
}
