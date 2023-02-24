package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelDetailScheduleEntity;
import com.greenart.travel_plan.entity.TsTpConnectionEntity;

public interface TravelDetailScheduleRepository extends JpaRepository <TravelDetailScheduleEntity ,Long> {
    public List<TravelDetailScheduleEntity> findByTsTpEntity (TsTpConnectionEntity connect);
}
