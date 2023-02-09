package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travle_plan.entity.MemberInfoEntity;

public interface MemberInfoRepository extends JpaRepository <MemberInfoEntity, Long> {
    
}
