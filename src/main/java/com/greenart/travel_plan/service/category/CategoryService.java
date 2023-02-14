package com.greenart.travel_plan.service.category;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.ParentZoneEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.repository.ChildZoneRepository;
import com.greenart.travel_plan.repository.ParentZoneRepository;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;
import com.greenart.travel_plan.vo.category.ChildZoneVO;
import com.greenart.travel_plan.vo.category.ParentZoneVO;

@Service
public class CategoryService {
    @Autowired ChildZoneRepository czRepo;
    @Autowired ParentZoneRepository pzRepo;
    @Autowired ZoneConnectionRepository zcRepo;

    public Map<String, Object> showCategory(Long seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        ParentZoneEntity parent = pzRepo.findById(seq).orElse(null);
        if(parent==null){
            return resultMap;
        }
        List<ZoneConnectionEntity> cate = zcRepo.findByParent(parent);
        List<ParentZoneVO> result = new ArrayList<>();
        for(ZoneConnectionEntity z : cate){
            ChildZoneVO childVO = new ChildZoneVO(z);
            ParentZoneVO pvo = new ParentZoneVO(z);
            pvo.setChild(childVO);
            result.add(pvo);
        }
        resultMap.put("data", result);
        return resultMap;





        // ZoneConnectionEntity cate = zcRepo.findBySeq(seq);
        // ParentZoneEntity cate = zcRepo.findBySeq(seq);
        // List<ZoneConnectionEntity> cate = zcRepo.findBySeq(seq);
        // ZoneConnectionEntity parent = zcRepo.findByCate(seq);
        // ZoneConnectionEntity parent = zcRepo.findBySeq(seq);
        // if (seq == null){
        //     resultMap.put("list", pzRepo.findAll());
        //     return resultMap;
        // }
        // else if(seq==1) {
        //     resultMap.put("list", pzRepo.findAllByPzSeq(seq));
        // }
        // Map<String, Object> list = new LinkedHashMap<>();
        // if(pzSeq==1){
        //     List<ParentZoneVO> parentList = pzRepo.
        //     if(parentList.size()!=0){
        //         list.put("burger", parentList);
        //     }


        // else if(seq==1){
        //     resultMap.put("seq", seq);
        //     resultMap.put("list", pzRepo.findAllByPzSeq(seq));
        //     return resultMap;
        // }

        // else if(seq==2){
        //     resultMap.put("seq", cate);
        //     resultMap.put("list", zcRepo.findBySeq(1L));
        // }
        // else if(seq==3){
        //     resultMap.put("seq", cate);
        //     resultMap.put("list", zcRepo.findBySeq(1L));
        // }
        // else if(seq==4){
        //     resultMap.put("seq", cate);
        //     resultMap.put("list", zcRepo.findBySeq(1L));
        // }
        // else if(seq==5){
        //     resultMap.put("seq", cate);
        //     resultMap.put("list", zcRepo.findBySeq(1L));
        // }
        // else if(seq==6){
        //     resultMap.put("seq", cate);
        //     resultMap.put("list", zcRepo.findBySeq(1L));
        // }
            
        
        // Map<String, Object> list = new LinkedHashMap<>();
    }
}
