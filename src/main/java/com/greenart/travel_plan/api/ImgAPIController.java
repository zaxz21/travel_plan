package com.greenart.travel_plan.api;

import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.greenart.travel_plan.entity.ImgInfoEntity;
import com.greenart.travel_plan.repository.ImgInfoRepository;
import com.greenart.travel_plan.service.ImgService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/images")
public class ImgAPIController {
    @Value ("${file.image.local}") String local_img_path;
    @Autowired ImgService imgService;
    @Autowired ImgInfoRepository imgRepo;

    // 이미지 업로드
    @PutMapping("/upload/local")
    public ResponseEntity<Object> ImgUpload(@RequestPart MultipartFile file) {
        Map<String, Object> resultMap = imgService.addLocalImage(file);   
        return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }

    // 이미지 다운로드
    @GetMapping("/download/local")
    public ResponseEntity<Resource> ImgDownload (@RequestParam String imgname,  HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            
        ImgInfoEntity entity = imgRepo.findByiiFileNameContaining(imgname);
        String searchname = entity.getIiFileName();
        // Path Pathsearchname = searchname;
        Path folderLocation = Paths.get(local_img_path);
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
    }

    // 이미지 삭제
    @DeleteMapping("/delete/local")
    public ResponseEntity<Object> ImgDelete (@RequestBody ImgInfoEntity data) {
        Map<String, Object> resultMap = imgService.deleteLocalImage(data);
        return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }
}
