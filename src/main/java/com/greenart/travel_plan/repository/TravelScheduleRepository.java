package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.greenart.travel_plan.entity.TravelScheduleEntity;

public interface TravelScheduleRepository extends JpaRepository<TravelScheduleEntity, Long> {
    private MemberInfoEntity memberEntity;

    public List<TravelScheduleEntity> findBySeq(Long tsSeq, );
}
