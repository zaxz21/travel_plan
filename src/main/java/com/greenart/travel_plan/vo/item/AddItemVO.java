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

public class AddItemVO {
    @Schema (description = "상위 준비물 이름" , example = "세면/화장품")
    private String piName;
    @Schema (description = "하위 준비물 이름" , example = "칫솔")
    private String ciName;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
