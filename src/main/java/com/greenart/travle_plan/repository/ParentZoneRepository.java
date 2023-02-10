package com.greenart.travle_plan.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travle_plan.entity.ParentZoneEntity;
import java.util.List;

public interface ParentZoneRepository extends JpaRepository<ParentZoneEntity, Long>{
    // List<ParentZoneEntity>findByPzSeq(Long seq);
}
