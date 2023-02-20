package com.greenart.travel_plan.vo.item;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateItemVO {
    private String ciName;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
