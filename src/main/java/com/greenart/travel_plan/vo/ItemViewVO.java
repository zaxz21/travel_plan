package com.greenart.travel_plan.vo;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ItemConnectionEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemViewVO {
    private List<ItemConnectionEntity> list;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
