package com.greenart.travel_plan.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

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
    @Column(name="ts_seq")      private Long          tsSeq;
    @Column(name="ts_date")     private LocalDateTime tsDate;
    @Column(name="ts_tt_seq")   private Long          tsTtSeq;
    @Column(name="ts_tp_seq")   private Long          tsTpSeq;
}


