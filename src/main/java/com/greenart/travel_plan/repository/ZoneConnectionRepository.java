package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.greenart.travel_plan.entity.ChildZoneEntity;
import com.greenart.travel_plan.entity.ParentZoneEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.vo.category.ParentZoneVO;

public interface ZoneConnectionRepository extends JpaRepository<ZoneConnectionEntity, Long> {
    public List<ZoneConnectionEntity> findByParent(ParentZoneEntity seq);
    public List<ZoneConnectionEntity> findByChild(ChildZoneEntity child );
    ZoneConnectionEntity findAllByChild(ChildZoneEntity child);
    List<ZoneConnectionEntity> findAllByParent(ParentZoneEntity parent);
    Long deleteBySeq(Long seq);
}