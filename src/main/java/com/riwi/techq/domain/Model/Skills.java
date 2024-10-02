package com.riwi.techq.domain.Model;

import com.riwi.techq.domain.Enums.SkillType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private SkillType skillType;

}
