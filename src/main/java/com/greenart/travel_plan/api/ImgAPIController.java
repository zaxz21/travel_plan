// package com.greenart.travel_plan.api;

// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

// import com.greenart.travel_plan.entity.ImgInfoEntity;
// import com.greenart.travel_plan.service.ImgService;

// @RestController
// public class ImgAPIController {
//     @Autowired ImgService imgService;

//     // 이미지 업로드
//     @PutMapping("/upload/local")
//     public ResponseEntity<Object> ImgUpload(@RequestPart MultipartFile file) {
//         Map<String, Object> resultMap = imgService.addLocalImage(file);   
//         return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
//     }

//     // 이미지 다운로드
//     @GetMapping("/download/local")
//     public ResponseEntity<Object> ImgDownload (@RequestParam String imgname, @RequestPart MultipartFile file){
//         Map<String, Object> resultMap = imgService.downLocalImage(imgname, file);
//         return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
//     }

//     // 이미지 삭제
//     @DeleteMapping("/delete/local")
//     public ResponseEntity<Object> ImgDelete (@RequestBody ImgInfoEntity data) {
//         Map<String, Object> resultMap = imgService.deleteLocalImage(data);
//         return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
//     }
// }
