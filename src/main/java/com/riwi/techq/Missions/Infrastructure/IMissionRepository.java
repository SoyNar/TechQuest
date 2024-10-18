package com.riwi.techq.Missions.Infrastructure;

import com.riwi.techq.Missions.Domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMissionRepository extends JpaRepository<Mission,Long> {

}
