package com.greenart.travel_plan.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.greenart.travel_plan.entity.ImgInfoEntity;
import com.greenart.travel_plan.repository.ImgInfoRepository;

import jakarta.transaction.Transactional;

@Service
public class ImgService {
    
    @Autowired ImgInfoRepository ImgRepo;
    @Autowired ImgService ImgServce;
    @Value("${file.image.local}") String local_img_path;
    
    // 이미지 업로드
    public Map<String, Object> addLocalImage(MultipartFile file) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        Path folderLocation = null;
        folderLocation = Paths.get(local_img_path);
        
        String saveFilename = "";
        String orginFileName = file.getOriginalFilename();

        String[]split = orginFileName.split("\\.");
        String firstname = split[split.length -2] + "_";
        String ext = split[split.length -1];

        Calendar c = Calendar.getInstance();
        saveFilename += firstname + c.getTimeInMillis() + "." + ext; 
        Path targetFile = folderLocation.resolve(saveFilename);

        try {
            Files.copy(file.getInputStream(), targetFile, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        ImgInfoEntity ImgEntity = ImgInfoEntity.builder().iiFileName(saveFilename).build();
        ImgRepo.save(ImgEntity);
        resultMap.put("status", true);
        resultMap.put("message", "파일이 저장되었습니다.");
        resultMap.put("code", HttpStatus.OK);

        return resultMap;
    }

    // 이미지 다운로드
    public Map<String, Object> downLocalImage (String imgname, MultipartFile file) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Path forderLocation = null;
        folderLocation = Paths.get(local_img_path);
        filename = 

        return resultMap;
    }

    // 이미지 삭제
    @Transactional
    public Map<String, Object> deleteLocalImage (ImgInfoEntity data) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        ImgRepo.deleteByIiSeq(data.getIiSeq());
        resultMap.put("status", true);
        resultMap.put("message", "삭제 되었습니다.");
        resultMap.put("code", HttpStatus.OK);

        return resultMap;
    }
}
