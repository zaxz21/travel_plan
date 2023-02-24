package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;

public interface TravelScheduleRepository extends JpaRepository<TravelScheduleEntity, Long> {
    // public TravelScheduleEntity findByMemberEntity(MemberInfoEntity member);

    public List<TravelScheduleEntity> findByMemberEntity(MemberInfoEntity member);
    
}
