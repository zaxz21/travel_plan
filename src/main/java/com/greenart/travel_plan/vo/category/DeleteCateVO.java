package com.greenart.travel_plan.vo.category;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DeleteCateVO {
    private Long seq;
    private String name;
    private String engname;
    private String explanation;
    private Double latitude;
    private Double longitude;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
