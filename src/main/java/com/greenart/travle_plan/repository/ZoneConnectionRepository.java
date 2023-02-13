package com.greenart.travle_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.greenart.travle_plan.entity.ParentZoneEntity;
import com.greenart.travle_plan.entity.ZoneConnectionEntity;
import com.greenart.travle_plan.vo.category.ParentZoneVO;

public interface ZoneConnectionRepository extends JpaRepository<ZoneConnectionEntity, Long>{
    List<ZoneConnectionEntity> findByParent(ParentZoneEntity seq);
    // List<ZoneConnectionEntity> findByParent(ParentZoneEntity parent);



    // ZoneConnectionEntity findBySeq(Long seq);
    // ParentZoneEntity findBySeq(Long seq);
    // List<ZoneConnectionEntity> findByCate(ParentZoneEntity parent);
    // List<ParentZoneEntity> findByZone(ZoneConnectionEntity zone);
    // ParentZoneEntity findAllByParentSeq(Long seq);
    // List<ParentZoneEntity> findByAllPzSeq(Long pzSeq);
}