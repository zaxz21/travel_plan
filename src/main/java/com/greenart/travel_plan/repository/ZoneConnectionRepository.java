package com.greenart.travel_plan.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;


public interface ZoneConnectionRepository extends JpaRepository<ZoneConnectionEntity, Long>{
    
}
