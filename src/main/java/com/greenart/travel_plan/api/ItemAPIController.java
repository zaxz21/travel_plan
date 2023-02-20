package com.greenart.travel_plan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.repository.ChildItemRepository;
import com.greenart.travel_plan.repository.ItemConnectionRepository;
import com.greenart.travel_plan.repository.ParentItemRepository;
import com.greenart.travel_plan.service.ItemService;
import com.greenart.travel_plan.vo.ItemViewVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "준비물 카테고리", description = "준비물 상세 조회")
@RestController
@RequestMapping("/api/item")
public class ItemAPIController {
    @Autowired ParentItemRepository     piRepo;
    @Autowired ChildItemRepository      ciRepo;
    @Autowired ItemConnectionRepository icRepo;
    @Autowired ItemService              itemService;
    

    @Operation(summary = "준비물 조회")
    @GetMapping("/view")
    public ItemViewVO showItem(){
        return itemService.showItem();
    }
}
