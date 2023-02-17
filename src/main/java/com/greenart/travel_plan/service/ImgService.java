package com.greenart.travel_plan.service;

import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.greenart.travel_plan.entity.ImgInfoEntity;
import com.greenart.travel_plan.repository.ImgInfoRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ImgService {
    
    // @Autowired ImgService ImgServce;
    @Autowired ImgInfoRepository ImgRepo;
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

        resultMap.put("image", ImgEntity);
        resultMap.put("status", true);
        resultMap.put("message", "파일이 저장되었습니다.");
        resultMap.put("code", HttpStatus.OK);

        return resultMap;
    }

    // 이미지 다운로드
    public ResponseEntity<Resource> downLocalImage (String imgname, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            
        ImgInfoEntity entity = ImgRepo.findByiiFileNameContaining(imgname);
        String searchname = entity.getIiFileName();

        // Path Pathsearchname = searchname;
        Path folderLocation = Paths.get(local_img_path);
        Path targetFile = folderLocation.resolve(searchname);

        Resource r = null;
        String contentType = null;

        try {
            r = new UrlResource(targetFile.toUri());
        } catch (Exception e) {
            e.printStackTrace(); }

        try {
            contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());
            if (contentType == null) { 
                contentType = "application/octet-stream"; 
            }
            } catch (Exception e) {
                e.printStackTrace(); }
                
                resultMap.put("status", true);
                resultMap.put("message", "이미지가 다운로드 되었습니다.");
                resultMap.put("code", HttpStatus.OK);
                //resultMap.put("type",
                // contentType(MediaType.parseMediaType(contentType)). 
                // header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename*=\"" + URLEncoder.encode(searchname, "UTF-8") + "\"").
                // body(r));
                // return resultMap;

        // contentType(MediaType.parseMediaType(contentType)). 
        // header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename*=\"" + URLEncoder.encode(searchname, "UTF-8") + "\"").
        // body(r);

        return ResponseEntity.ok().
        contentType(MediaType.parseMediaType(contentType)). 
        header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename*=\"" + URLEncoder.encode(searchname, "UTF-8") + "\"").
        body(r);

        // resultMap.put("status", true);
        // resultMap.put("message", "이미지가 다운로드 되었습니다.");
        // resultMap.put("code", HttpStatus.OK);
        // return resultMap;

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
