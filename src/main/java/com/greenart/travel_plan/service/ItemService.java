 package com.greenart.travel_plan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.repository.ChildItemRepository;
import com.greenart.travel_plan.repository.ItemConnectionRepository;
import com.greenart.travel_plan.repository.ParentItemRepository;
import com.greenart.travel_plan.vo.ItemViewVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
    @Autowired ParentItemRepository piRepo;
    @Autowired ChildItemRepository ciRepo;
    @Autowired ItemConnectionRepository icRepo;

    public ItemViewVO showItem() {
        ItemViewVO iVo = ItemViewVO.builder()
        .status(true)
        .message("준비물을 조회했습니다.")
        .code(HttpStatus.ACCEPTED)
        .list(icRepo.findAll())
        .build();
        return iVo;
    }
}
