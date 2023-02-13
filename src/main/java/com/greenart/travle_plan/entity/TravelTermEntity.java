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
@Table(name="travel_term")
public class TravelTermEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "여행기간 번호", example ="1" )
    @Column(name="tt_seq")        private Long tsSeq;
    @Schema (description = "여행 시작 날짜" )
    @Column(name="tt_start_date") private Date ttStartDate;
    @Schema (description = "여행 끝 날짜" )
    @Column(name="tt_end_date")   private Date ttEndDate;
    @Schema (description = "회원 번호" )
    @Column(name="tt_mi_seq")     private Long ttMiSeq;
}


