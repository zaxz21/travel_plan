package com.greenart.travel_plan.vo.category;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllCateResponseVO {
    private List<ZoneConnectionEntity> list;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
