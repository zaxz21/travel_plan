package com.greenart.travle_plan.service.category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenart.travle_plan.entity.ZoneConnectionEntity;
import com.greenart.travle_plan.repository.ChildZoneRepository;
import com.greenart.travle_plan.repository.ParentZoneRepository;
import com.greenart.travle_plan.repository.ZoneConnectionRepository;

@Service
public class CategoryService {
    @Autowired ChildZoneRepository czRepo;
    @Autowired ParentZoneRepository pzRepo;
    @Autowired ZoneConnectionRepository zcRepo;

    public Map<String, Object> showCategory(Long seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        ZoneConnectionEntity cate = zcRepo.findBySeq(seq);
        // ZoneConnectionEntity parent = zcRepo.findBySeq(seq);
        if (cate == null){
            resultMap.put("list", zcRepo.findAll());
        }
        else if(seq==1){
            resultMap.put("seq", cate);
            resultMap.put("list", zcRepo.findBySeq(1L));
            // resultMap.put("list", zcRepo.findBy(1L));
        }
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
        return resultMap;
        // Map<String, Object> list = new LinkedHashMap<>();
    }
}
