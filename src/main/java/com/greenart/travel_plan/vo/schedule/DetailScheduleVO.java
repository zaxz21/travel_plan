package com.greenart.travel_plan.vo.schedule;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
@Tag(name = "상세 일정 등록", description = "여행의 각 일자별 일정 등록")
@Data
public class DetailScheduleVO {
    @Schema(description = "기본 일정 번호",example = "1") 
    private Long tsSeq;
    @Schema(description = "여행지 번호",example = "1") 
    private Long tpSeq;
    @Schema(description = "날짜(기본 일정에 등록되있는 시작날짜와 종료 날짜 사이의 값만 입력가능)",example = "2022-01-02") 
    private LocalDate data;
}
