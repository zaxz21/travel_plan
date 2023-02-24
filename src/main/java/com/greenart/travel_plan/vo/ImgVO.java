package com.greenart.travel_plan.vo;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ImgInfoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ImgVO {
    @Schema (description = "상태" , example = "true")
    private Boolean status;
    @Schema (description = "메시지" , example = "등록성공")
    private String message;
    @Schema (description = "code" , example = "ok")
    private HttpStatus code;
}