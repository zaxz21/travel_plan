package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greenart.travle_plan.entity.TravelScheduleEntity;

public interface TravelScheduleRepository extends JpaRepository<TravelScheduleEntity, Long> {
    
}
