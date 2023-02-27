package com.greenart.travel_plan.vo.schedule;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDeleteVO {
    private String message;
    private HttpStatus code;
    private Boolean status;
    
}
