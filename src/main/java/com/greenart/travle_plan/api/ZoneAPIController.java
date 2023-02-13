package com.greenart.travle_plan.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travle_plan.entity.ZoneConnectionEntity;
import com.greenart.travle_plan.repository.ChildZoneRepository;
import com.greenart.travle_plan.repository.ParentZoneRepository;
import com.greenart.travle_plan.repository.ZoneConnectionRepository;
// import com.greenart.travle_plan.service.category.CategoryService;
// import com.greenart.travle_plan.service.category.CategoryService;
import com.greenart.travle_plan.service.category.CategoryService;

@RestController
@RequestMapping("/zone")
public class ZoneAPIController {
    @Autowired ChildZoneRepository czRepo;
    @Autowired ParentZoneRepository pzRepo;
    @Autowired ZoneConnectionRepository zcRepo;
    @Autowired CategoryService cateService;

    // 카테 조회
    @GetMapping("/cate")
    public List<ZoneConnectionEntity> selectCategories(){
        List<ZoneConnectionEntity> resultMap = zcRepo.findAll();
        return resultMap;
    }
    @GetMapping("/cate/{seq}")
    public ResponseEntity<Object> getIngredient(@PathVariable Long seq){
        Map<String, Object> resultMap = cateService.showCategory(seq);
        return new ResponseEntity<Object>(resultMap ,HttpStatus.OK);
    }
}
