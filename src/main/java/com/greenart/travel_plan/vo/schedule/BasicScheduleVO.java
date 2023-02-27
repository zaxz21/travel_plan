package com.greenart.travel_plan.vo.schedule;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Tag(name = "기본 일정 등록", description = "여행의 전체적인 일정 등록(기간/이름/해당일정에 방문하려는 여행지)")
@Data
public class BasicScheduleVO {
    @Schema(description = "여행시작날짜" ,example = "2022-01-01")
    private LocalDate tsStartDate;
    @Schema(description = "여행종료날짜" ,example = "2022-01-10")
    private LocalDate tsEndDate;
    @Schema(description = "일정이름" ,example = "제주도")
    private String tsName;
    @Schema(description = "로그인한 회원의 번호", example = "5")
    private Long miSeq;
    @Schema(description = "회원이 일정에 추가하는 여행지 번호" ,example = "1")
    private Long tpSeq;
}
