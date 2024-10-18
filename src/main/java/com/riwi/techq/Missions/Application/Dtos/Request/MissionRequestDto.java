package com.riwi.techq.Missions.Application.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MissionRequestDto {
    @NotNull
    private String name;
    @NotNull
    private List<String> skillsName;
    @NotNull
    private List<String> nameStudent;
}
