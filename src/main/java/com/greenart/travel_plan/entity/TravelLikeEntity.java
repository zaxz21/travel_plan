package com.greenart.travel_plan.entity;


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
@Table(name="travel_like")
public class TravelLikeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tl_seq")      private Long tlSeq;
    @Column(name="tl_tp_seq")   private Long tlTpSeq;
    @Column(name="tl_mi_seq")   private Long tlMiSeq;
}
