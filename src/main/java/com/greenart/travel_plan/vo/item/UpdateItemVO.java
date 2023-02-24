package com.greenart.travel_plan.vo.item;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateItemVO {
    @Schema (description = "수정할 준비물 이름" , example = "로션")
    private String piName;
    private String ciName;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
