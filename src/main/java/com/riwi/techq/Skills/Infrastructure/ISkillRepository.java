package com.riwi.techquesproject.Skills.Infrastructure;

import com.riwi.techquesproject.Skills.Domain.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISkillRepository extends JpaRepository<Skills,Long> {
  Optional<Skills> findByName(String name);
  List<Skills> findByNameIn(List<String> skillsName);
}
