package com.greenart.travel_plan.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.ImgInfoEntity;
import com.greenart.travel_plan.repository.ImgInfoRepository;

@Service
public class ImgService {
    @Autowired ImgInfoRepository ImgRepo;
    public Map<String, Object> addLocalImage(ImgInfoEntity data) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        ImgRepo.save(data);
        resultMap.put("status", true);
        resultMap.put("message", "파일이 저장되었습니다.");
        resultMap.put("code", HttpStatus.OK);
        return resultMap;
    }
}
