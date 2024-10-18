package com.riwi.techq.Missions.Domain;

import com.riwi.techq.Auth.Domain.User;
import com.riwi.techq.Skills.Domain.Skills;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    @ManyToMany
    @JoinTable(
            name = "mission_users",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userMission;


    @ManyToMany
    @JoinTable(
            name = "mission_skills",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id")
    )    private List<Skills> missionSkill;
}
