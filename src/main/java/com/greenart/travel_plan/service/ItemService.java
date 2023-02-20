 package com.greenart.travel_plan.service;

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

    public AddItemVO addItem(AddItemVO data){
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

    public UpdateItemVO updateItem(UpdateItemVO data, Long seq){
        ChildItemEntity child = ciRepo.findByCiSeq(seq);
        if(child == null){
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

    @Transactional
    public void deleteCate(Long seq){
        ciRepo.deleteById(seq);
    }
    public DeleteItemVO deleteCate(DeleteItemVO data, Long seq){
        ChildItemEntity child = ciRepo.findByCiSeq(seq);
        if(child == null){
            DeleteItemVO dVo = DeleteItemVO.builder()
            .status(false)
            .message("잘못된 번호입니다.")
            .code(HttpStatus.BAD_REQUEST)
            .build();
            return dVo;
    }
    else{
        ciRepo.deleteById(seq);
            DeleteItemVO dVo = DeleteItemVO.builder()
                .status(true)
                .message("삭제되었습니다.")
                .code(HttpStatus.ACCEPTED)
                .build();
                return dVo;
        }
    }
}
