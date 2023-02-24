package com.greenart.travel_plan.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ParentZoneEntity;

import java.util.List;

public interface ParentZoneRepository extends JpaRepository<ParentZoneEntity, Long>{
    List<ParentZoneEntity>findAllByPzSeq(Long seq);
    public ParentZoneEntity findByNameContains(String name);
    ParentZoneEntity findByPzSeq(Long seq);
    Long deleteByPzSeq(Long seq);
}
