package com.riwi.techq.Skills.Application.Controller;

import com.riwi.techq.Skills.Application.Dtos.Response.SkillResponseDto;
import com.riwi.techq.Skills.Application.Dtos.Resquest.SkillRequestDto;
import com.riwi.techq.Skills.Application.IService.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private ISkillService   skillService;

    // crear una habilidad solo para admin y teacher
    @PostMapping("/create")
    public ResponseEntity<SkillResponseDto> createSkillOne( @RequestBody SkillRequestDto requestDto){
        SkillResponseDto responseDto = this.skillService.createSkill(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
