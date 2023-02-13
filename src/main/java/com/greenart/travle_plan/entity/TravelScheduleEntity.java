package com.greenart.travle_plan.entity;


import java.lang.annotation.Inherited;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@DynamicInsert
@Table(name="travel_schedule")
public class TravelScheduleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "여행일정 번호",example = "1" )
    @Column(name="ts_seq")      private Long          tsSeq;
    @Schema (description = "일정이름" )
    @Column(name="ts_name")      private String          tsName;
    @Schema (description = "날짜" )
    @Column(name="ts_date")     private LocalDateTime tsDate;
    @Schema (description = "여행기간 번호" )
    @Column(name="ts_tt_seq")   private Long          tsTtSeq;
    @Schema (description = "여행지 번호" )
    @Column(name="ts_tp_seq")   private Long          tsTpSeq;
}


