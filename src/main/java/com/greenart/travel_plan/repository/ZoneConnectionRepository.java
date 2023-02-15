package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.greenart.travel_plan.entity.ParentZoneEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.vo.category.ParentZoneVO;

public interface ZoneConnectionRepository extends JpaRepository<ZoneConnectionEntity, Long>{
    List<ZoneConnectionEntity> findByParent(ParentZoneEntity seq);
    // public Integer countByParent(ParentZoneEntity seq);
}