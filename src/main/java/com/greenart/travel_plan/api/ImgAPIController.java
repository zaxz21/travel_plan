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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "이미지", description = "이미지 다운로드 업로드 API")
@RestController
@RequestMapping("/api/images")
public class ImgAPIController {
    @Value ("${file.image.local}") String local_img_path;
    @Autowired ImgService imgService;
    @Autowired ImgInfoRepository imgRepo;

    // 이미지 업로드
    @Operation(summary = "이미지 업로드 기능")
    @PutMapping("/upload/local")
    public ResponseEntity<Object> ImgUpload(
        @Parameter(name = "file",description = "이미지 원본 파일")  
        @RequestPart MultipartFile file) {
        Map<String, Object> resultMap = imgService.addLocalImage(file);   
        return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }

    // 이미지 다운로드
    @Operation(summary = "이미지 다운로드 기능")
    @GetMapping("/download/local")
    public ResponseEntity<Resource> ImgDownload (
        @Parameter(name = "imgname",description = "받을 이미지 이름")
        @RequestParam String imgname,
        @Parameter(name = "request",description = "이미지 원본 파일")
        HttpServletRequest request) throws Exception {
        // Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            
        ImgInfoEntity entity = imgRepo.findByiiFileName(imgname);
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
                
        return ResponseEntity.ok().
        contentType(MediaType.parseMediaType(contentType)). 
        header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename*=\"" + URLEncoder.encode(searchname, "UTF-8") + "\"").
        body(r);
    }

    // 이미지 삭제
    @Operation(summary = "이미지 삭제")
    @DeleteMapping("/delete/local")
    public ResponseEntity<Object> ImgDelete (
        @Parameter(description = "삭제할 이미지 엔티티 데이터( 이미지 번호 )")
        @RequestBody ImgInfoEntity data) {
        Map<String, Object> resultMap = imgService.deleteLocalImage(data);
        return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }
}
