package com.greenart.travel_plan.vo;

import java.util.List;

import com.greenart.travel_plan.entity.TravelLikeCountEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class TravelReponseVO {
    @Schema(description = "여행지 리스트")
       private List <TravelLikeCountEntity> list;
       @Schema(description = "총 여행지 수",example = "123")
       private Long total;
       @Schema(description = "총 페이지 수", example = "13")
       private Integer totalPage;
       @Schema(description = "조회한 페이지(1페이지 -> 0 / 2페이지 -> 1)" , example = "0")
       private Integer currentPage;
       @Schema(description = "오류 메세지" , example = "검색어를 입력해주세요")
       private String message;
}

