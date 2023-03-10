package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ChildItemEntity;
import com.greenart.travel_plan.entity.ItemConnectionEntity;
import com.greenart.travel_plan.entity.ParentItemEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface ItemConnectionRepository extends JpaRepository<ItemConnectionEntity, Long>{
    List<ItemConnectionEntity> findByPitem(ParentItemEntity pitem);
    ItemConnectionEntity findBypitem(ParentItemEntity pitem);
    ItemConnectionEntity findBycitem(ChildItemEntity citem);
    ItemConnectionEntity deleteByCitem(ChildItemEntity citem);
    List<ItemConnectionEntity> findByCitem(ChildItemEntity citem);
    ItemConnectionEntity findAllBypitem(ItemConnectionEntity icEntity);
    Long deleteByIcSeq(Long icSeq);
}
