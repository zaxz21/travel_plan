package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.MemberInfoEntity;

public interface MemberInfoRepository extends JpaRepository <MemberInfoEntity, Long> {
    public Integer countByMiEmail(String miEmail);
    public MemberInfoEntity findByMiEmailAndMiPwd(String miEmail, String miPwd);
    public MemberInfoEntity findByMiSeq(Long miseq);
}
