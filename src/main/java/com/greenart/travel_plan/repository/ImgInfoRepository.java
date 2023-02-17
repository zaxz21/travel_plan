package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ImgInfoEntity;

public interface ImgInfoRepository extends JpaRepository <ImgInfoEntity, Long> {
    public void deleteByIiSeq(Long iiSeq);
    public String findByIiFileName(String iiFileName);
    public List<ImgInfoEntity> findByiiFileName(String iiFileName);

    public ImgInfoEntity findByiiFileNameContaining (String iiFileName);
}
