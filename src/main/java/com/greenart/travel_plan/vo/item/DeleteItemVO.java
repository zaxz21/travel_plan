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
public class DeleteItemVO {
    @Schema (description = "삭제할 준비물 번호" , example = "1")
    private Long seq;
    private String name;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
