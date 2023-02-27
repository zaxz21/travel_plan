package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.BasicScheduleViewEntity;

public interface BasicScheduleViewReposttory  extends JpaRepository<BasicScheduleViewEntity,Long>{
    public BasicScheduleViewEntity findByTsSeq(Long tsseq);

    
}
