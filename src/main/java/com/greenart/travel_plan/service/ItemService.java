package com.greenart.travel_plan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.ChildItemEntity;
import com.greenart.travel_plan.entity.ItemConnectionEntity;
import com.greenart.travel_plan.entity.ParentItemEntity;
import com.greenart.travel_plan.repository.ChildItemRepository;
import com.greenart.travel_plan.repository.ItemConnectionRepository;
import com.greenart.travel_plan.repository.ParentItemRepository;
import com.greenart.travel_plan.vo.item.AddItemVO;
import com.greenart.travel_plan.vo.item.DeleteItemVO;
import com.greenart.travel_plan.vo.item.ItemViewVO;
import com.greenart.travel_plan.vo.item.UpdateItemVO;

import jakarta.transaction.Transactional;
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

    public AddItemVO addItem(AddItemVO data) {
        ParentItemEntity piz = piRepo.findByPiNameContains(data.getPiName());
        if(piz == null){
            ParentItemEntity entity = ParentItemEntity.builder()
            .piName(data.getPiName())
            .build();
            piRepo.save(entity);
            ChildItemEntity eEntity = ChildItemEntity.builder()
            .ciName(data.getCiName())
            .build();
            ciRepo.save(eEntity);
            ItemConnectionEntity iEntity = new ItemConnectionEntity(null, entity, eEntity);
            icRepo.save(iEntity);
            AddItemVO addItemVO = AddItemVO.builder()
            .status(true)
            .message("추가하였습니다")
            .code(HttpStatus.ACCEPTED)
            .build();
            return addItemVO;
        }
        else{
            ChildItemEntity childItemEntity = ChildItemEntity.builder()
            .ciName(data.getCiName())
            .build();
            ciRepo.save(childItemEntity);
            ItemConnectionEntity itemConnectionEntity = new ItemConnectionEntity(null, piz, childItemEntity);
            icRepo.save(itemConnectionEntity);
            AddItemVO addItemVO = AddItemVO.builder()
            .status(true)
            .message("추가하였습니다")
            .code(HttpStatus.ACCEPTED)
            .build();
            return addItemVO;
        }
    }

    public UpdateItemVO updateItem(UpdateItemVO data, Long seq, String type) {
        ChildItemEntity child = ciRepo.findById(seq).get();
        ParentItemEntity parent = piRepo.findByPiSeq(seq);
        if(type.equals("pi")) {
            if(parent == null) {
                UpdateItemVO uVo = UpdateItemVO.builder()
                .status(false)
                .message("잘못된 번호입니다.")
                .code(HttpStatus.BAD_REQUEST)
                .build();
                return uVo;
            }
            else{
                if(data.getPiName() != null){
                    parent.setPiName(data.getPiName());
                    piRepo.save(parent);
                    UpdateItemVO uVo = UpdateItemVO.builder()
                    .status(true)
                    .message("수정하였습니다.")
                    .code(HttpStatus.ACCEPTED)
                    .piName(data.getPiName())
                    .build();
                    return uVo;
                }
                else{
                    UpdateItemVO uVo = UpdateItemVO.builder()
                    .status(false)
                    .message("준비물을 입력해주세요.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
                    return uVo;
                    }
                }
        }
        else if(type.equals("ci")) {
            if(child == null) {
                UpdateItemVO uVo = UpdateItemVO.builder()
                .status(false)
                .message("잘못된 번호입니다.")
                .code(HttpStatus.BAD_REQUEST)
                .build();
                return uVo;
            }
            else{
                if(data.getCiName() != null){
                    child.setCiName(data.getCiName());
                    ciRepo.save(child);
                    UpdateItemVO uVo = UpdateItemVO.builder()
                    .status(true)
                    .message("수정하였습니다.")
                    .code(HttpStatus.ACCEPTED)
                    .ciName(data.getCiName())
                    .build();
                    return uVo;
                }
                else{
                    UpdateItemVO uVo = UpdateItemVO.builder()
                    .status(false)
                    .message("준비물을 입력해주세요.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
                    return uVo;
                    }
                }
            }
            else {
                UpdateItemVO uVo = UpdateItemVO.builder()
                    .status(false)
                    .message("pi 또는 ci를 입력해주세요.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
                    return uVo;
            }
        }
        
            
        

    @Transactional
    public DeleteItemVO deleteItem(DeleteItemVO data, Long seq, String type) {
        if(type.equals("pi")) {
            ParentItemEntity pEntity = piRepo.findByPiSeq(seq);
            List<ItemConnectionEntity> iclist = icRepo.findByPitem(pEntity);
            List<ChildItemEntity> child = new ArrayList<ChildItemEntity>(); 
            for(int i=0 ; i<iclist.size(); i++ ) {
                child.addAll(ciRepo.findByCiSeq(iclist.get(i).getCitem().getCiSeq()));
            }
            
            if(pEntity == null) {
                DeleteItemVO dVo = DeleteItemVO.builder()
                .status(false)
                .message("잘못된 번호입니다.")
                .code(HttpStatus.BAD_REQUEST)
                .build();
                return dVo;
            }
            
            icRepo.deleteAll(iclist);
            ciRepo.deleteAll(child);
            piRepo.delete(pEntity);
    
            DeleteItemVO dVo = DeleteItemVO.builder()
                .status(true)
                .message("삭제되었습니다.")
                .code(HttpStatus.ACCEPTED)
                .build();
                return dVo;
            
        }
        else if(type.equals("ci")){
            ChildItemEntity child = ciRepo.findById(seq).get();
            ItemConnectionEntity itEntity = icRepo.findBycitem(child);
    
            if(child == null) {
                DeleteItemVO dVo = DeleteItemVO.builder()
                .status(false)
                .message("잘못된 번호입니다.")
                .code(HttpStatus.BAD_REQUEST)
                .build();
                return dVo;
            }
            icRepo.deleteByIcSeq(itEntity.getIcSeq());
            ciRepo.deleteByCiSeq(seq);
    
            DeleteItemVO dVo = DeleteItemVO.builder()
                .status(true)
                .message("삭제되었습니다.")
                .code(HttpStatus.ACCEPTED)
                .build();
                return dVo;
            }
        else {
            DeleteItemVO dVo = DeleteItemVO.builder()
                .status(false)
                .message("pi번호 또는 ci번호를 입력하세요")
                .code(HttpStatus.BAD_REQUEST)
                .build();
                return dVo;
        }
    }
}
