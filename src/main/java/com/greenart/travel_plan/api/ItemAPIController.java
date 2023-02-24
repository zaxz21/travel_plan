package com.greenart.travel_plan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.ChildItemEntity;
import com.greenart.travel_plan.repository.ChildItemRepository;
import com.greenart.travel_plan.repository.ItemConnectionRepository;
import com.greenart.travel_plan.repository.ParentItemRepository;
import com.greenart.travel_plan.service.ItemService;
import com.greenart.travel_plan.vo.item.AddItemVO;
import com.greenart.travel_plan.vo.item.DeleteItemVO;
import com.greenart.travel_plan.vo.item.ItemViewVO;
import com.greenart.travel_plan.vo.item.UpdateItemVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "준비물 카테고리", description = "준비물 상세 조회")
@RestController
@RequestMapping("/api/item")
public class ItemAPIController {
    @Autowired ParentItemRepository     piRepo;
    @Autowired ChildItemRepository      ciRepo;
    @Autowired ItemConnectionRepository icRepo;
    @Autowired ItemService              itemService;
    
    // 준비물 조회
    @Operation(summary = "준비물 조회")
    @GetMapping("/view")
    public ItemViewVO showItem(){
        return itemService.showItem();
    }

    // 준비물 추가
    @Operation(summary = "준비물 추가")
    @PutMapping("/add")
    public ResponseEntity<AddItemVO> addItem(AddItemVO data){
        return new ResponseEntity<>(itemService.addItem(data), HttpStatus.OK);
    }

    // 준비물 수정
    @Operation(summary = "준비물 수정")
    @PatchMapping("/update/{type}/{seq}")
    public ResponseEntity<UpdateItemVO> updateItem(UpdateItemVO data, @Parameter(name = "type", description = "상위:pi / 하위: ci") @PathVariable String type,
                                                                        @Parameter(name = "seq", description = "수정할 준비물 번호") @PathVariable Long seq) {
        return new ResponseEntity<>(itemService.updateItem(data, seq, type), HttpStatus.OK);
    }

    // 준비물 삭제
    @Operation(summary = "준비물 삭제")
    @DeleteMapping("/delete/{type}/{seq}")
    public ResponseEntity<DeleteItemVO> deleteItem(DeleteItemVO data,  @Parameter(name = "type", description = "상위:pi / 하위: ci")@PathVariable String type,
                                                                        @Parameter(name = "seq", description = "삭제할 준비물 번호") @PathVariable Long seq) {
        return new ResponseEntity<>(itemService.deleteItem(data, seq, type), HttpStatus.OK);
    }

}
