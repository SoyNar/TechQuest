package com.riwi.techq.domain.Model;

import com.riwi.techq.domain.Enums.DifficultyLevel;
import jakarta.persistence.*;

import java.util.List;

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
