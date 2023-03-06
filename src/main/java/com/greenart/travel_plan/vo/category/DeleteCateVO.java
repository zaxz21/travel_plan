package com.greenart.travel_plan.vo.category;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DeleteCateVO {
    @Schema (description = "삭제할 카테고리 번호" , example = "1")
    // private Long seq;
    // private String name;
    // private String engname;
    // private String explanation;
    // private Double latitude;
    // private Double longitude;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
