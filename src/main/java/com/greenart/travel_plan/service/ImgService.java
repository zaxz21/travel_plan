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
import com.greenart.travel_plan.vo.ImgVO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ImgService {
    
    // @Autowired ImgService ImgServce;
    @Autowired ImgInfoRepository ImgRepo;
    @Value("${file.image.local}") String local_img_path;
    
    // 이미지 업로드
    public ImgVO addLocalImage(MultipartFile file) {
        // Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Path folderLocation = null;
        folderLocation = Paths.get(local_img_path);
        
        String saveFilename = "";
        String orginFileName = file.getOriginalFilename();

        String[]split = orginFileName.split("\\."); 

        String firstname = "";  //split[0] + "_";
        String ext = split[split.length -1];
        for(int i=0; i<split.length; i++) {
            if(i != split.length - 1)
                firstname += split[i];
        }

        Calendar c = Calendar.getInstance();
        saveFilename += firstname + c.getTimeInMillis() + "." + ext; 
        Path targetFile = folderLocation.resolve(saveFilename);

        try {
            Files.copy(file.getInputStream(), targetFile, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        ImgInfoEntity ImgEntity = ImgInfoEntity.builder()
            .iiFileName(saveFilename)
            .build();
            ImgRepo.save(ImgEntity);

        ImgVO vo = ImgVO.builder()
            .status(true)
            .message("파일이 저장되었습니다.")
            .code(HttpStatus.ACCEPTED)
            .build();
        System.out.println(vo);
        return vo;
    }

    // 이미지 다운로드
    public ResponseEntity<Resource> downLocalImage (String imgname, HttpServletRequest request) throws Exception {
        
        ImgInfoEntity entity = ImgRepo.findByiiFileName(imgname);
        String searchname = entity.getIiFileName();
        // Path Pathsearchname = searchname;
        Path folderLocation = Paths.get(local_img_path);
        String[]split = searchname.split("\\."); 
        String ext = split[split.length -1];

        String[]split2 = searchname.split("_"); 
        
        Path targetFile = folderLocation.resolve(searchname);
        Resource r = null;
        String contentType = null;
        try {
            r = new UrlResource (targetFile.toUri());
        } catch (Exception e) {
            e.printStackTrace(); }

        try {
            contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());
            if (contentType == null) { 
                contentType = "application/octet-stream"; 
            }
            } catch (Exception e) {
                e.printStackTrace(); }
                
        return ResponseEntity.ok().
        contentType(MediaType.parseMediaType(contentType)). 
        header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + URLEncoder.encode(searchname, "UTF-8") + "\"").
        body(r);
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
