package com.greenart.travel_plan.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ChildZoneEntity;


public interface ChildZoneRepository extends JpaRepository<ChildZoneEntity, Long>{
    public ChildZoneEntity findBySeq(Long seq);
    public ChildZoneEntity findByNameContains(String keyword);
    Long deleteBySeq(Long seq);
}
