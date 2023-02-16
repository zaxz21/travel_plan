package com.greenart.travel_plan.service.category;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.ChildZoneEntity;
import com.greenart.travel_plan.entity.ParentZoneEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.repository.ChildZoneRepository;
import com.greenart.travel_plan.repository.ParentZoneRepository;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;
import com.greenart.travel_plan.vo.category.AddZoneVO;
import com.greenart.travel_plan.vo.category.AllCateResponseVO;
import com.greenart.travel_plan.vo.category.CateResponseVO;
import com.greenart.travel_plan.vo.category.ChildZoneVO;
import com.greenart.travel_plan.vo.category.DeleteCateVO;
import com.greenart.travel_plan.vo.category.ParentZoneVO;
import com.greenart.travel_plan.vo.category.UpdateCateVO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    @Autowired ChildZoneRepository czRepo;
    @Autowired ParentZoneRepository pzRepo;
    @Autowired ZoneConnectionRepository zcRepo;


    public AllCateResponseVO showAllCate(AllCateResponseVO data){
        AllCateResponseVO aVo = AllCateResponseVO.builder()
            .status(true)
            .message("모든 지역을 조회했습니다.")
            .code(HttpStatus.ACCEPTED)
            .list(zcRepo.findAll())
            .build();
            return aVo;
    }

    public CateResponseVO showCategory(Long seq){
        ParentZoneEntity parent = pzRepo.findById(seq).orElse(null);
        if(parent==null){
            CateResponseVO cVo = CateResponseVO.builder()
            .status(false)
            .message("결과가 존재하지않습니다.")
            .code(HttpStatus.NOT_FOUND)
            .build();
            return cVo;
        }
        List<ZoneConnectionEntity> cate = zcRepo.findByParent(parent);
        List<ParentZoneVO> result = new ArrayList<>();
        for(ZoneConnectionEntity z : cate){
            ChildZoneVO childVO = new ChildZoneVO(z);
            ParentZoneVO pvo = new ParentZoneVO(z);
            pvo.setChild(childVO);
            result.add(pvo);
        }
        CateResponseVO cVo = CateResponseVO.builder()
            .status(true)
            .message("조회하였습니다.")
            .code(HttpStatus.ACCEPTED)
            .list(result)
            .build();
            return cVo;
    }
    public AddZoneVO addCategory(AddZoneVO data){
        ParentZoneEntity entity = ParentZoneEntity.builder()
        .name(data.getPzName())
        .build();
        pzRepo.save(entity);
        ChildZoneEntity cEntity = ChildZoneEntity.builder()
        .name(data.getCzName())
        .engname(data.getCzEngname())
        .latitude(data.getCzLatitude())
        .longitude(data.getCzLongitude())
        .explanation(data.getCzExplanation())
        // .image(data.getImage())
        .build();
        czRepo.save(cEntity);
        ZoneConnectionEntity zEntity = new ZoneConnectionEntity(null,entity,cEntity);
        zcRepo.save(zEntity);
        AddZoneVO aVo = AddZoneVO.builder()
        .status(true)
        .message("추가하였습니다.")
        .code(HttpStatus.ACCEPTED)
        // .pzName(data.getPzName())
        // .czName(data.getCzName())
        // .czExplanation(data.getCzExplanation())
        .build();
        return aVo;
    }
    
    public UpdateCateVO updateCategory(UpdateCateVO data, Long seq){
    ChildZoneEntity child = czRepo.findBySeq(seq);
    // .findById(seq).get();
    if(child == null){
        UpdateCateVO uVo = UpdateCateVO.builder()
        .status(false)
        .message("잘못된 지역 번호입니다.")
        .code(HttpStatus.BAD_REQUEST)
        .build();
        return uVo;
    }
    else{
        if(data.getCzName() != null && data.getCzExplanation() != null){
            child.setName(data.getCzName());
            child.setExplanation(data.getCzExplanation());
            child.setEngname(data.getCzEngName());
            czRepo.save(child);
            UpdateCateVO uVo = UpdateCateVO.builder()
            .status(true)
            .message("수정하였습니다.")
            .code(HttpStatus.ACCEPTED)
            .czName(data.getCzName())
            .czEngName(data.getCzEngName())
            .czExplanation(data.getCzExplanation())
            .build();
            return uVo;

        }
        else{
            UpdateCateVO uVo = UpdateCateVO.builder()
            .status(false)
            .message("이름과 설명을 입력해주세요.")
            .code(HttpStatus.BAD_REQUEST)
            .build();
            return uVo;
            }
        }
    }

    @Transactional
    public void deleteCate(Long seq){
        czRepo.deleteById(seq);
    }
    public DeleteCateVO deleteCate(DeleteCateVO data, Long seq){
        ChildZoneEntity child = czRepo.findBySeq(seq);
        if(child == null){
            DeleteCateVO dVo = DeleteCateVO.builder()
            .status(false)
            .message("잘못된 지역 번호입니다.")
            .code(HttpStatus.BAD_REQUEST)
            .build();
            return dVo;
    }
    else{
        czRepo.deleteById(seq);
            DeleteCateVO dVo = DeleteCateVO.builder()
                .status(true)
                .message("삭제되었습니다.")
                .code(HttpStatus.ACCEPTED)
                .build();
                return dVo;
        }
    }
}
