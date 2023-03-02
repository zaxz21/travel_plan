package com.greenart.travel_plan.vo.schedule;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.DetailScheduleViewEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailScheduleListVO {
    private Long tsseq;
    private String tsname;
    private List<DetailScheduleViewEntity> dlist;
    private String message;
    private Boolean status;
    private HttpStatus code;


    
}
