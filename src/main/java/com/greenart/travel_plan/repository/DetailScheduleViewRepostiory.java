package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.DetailScheduleViewEntity;

public interface DetailScheduleViewRepostiory extends JpaRepository<DetailScheduleViewEntity,Long> {
    public List<DetailScheduleViewEntity> findByTsSeq(Long tsseq);
    
}
