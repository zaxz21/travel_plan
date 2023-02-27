package com.greenart.travel_plan.vo.schedule;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Tag(name = "기본 일정 수정", description = "여행일정 수정(기간/이름)")
@Data
public class UpdateBasicScheduleVO {
    @Schema(description ="수정할 이름", example= "신나는 제주도 여행")
    private String tsName;
    @Schema(description = "수정할 여행시작날짜" ,example = "2022-01-01")
    private LocalDate tsStartDate;
    @Schema(description = "수정할 여행종료날짜" ,example = "2022-01-10")
    private LocalDate tsEndDate;
}
