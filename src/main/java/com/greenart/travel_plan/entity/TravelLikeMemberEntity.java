package com.greenart.travel_plan.entity;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travel_like_member")
@Immutable
@Entity
public class TravelLikeMemberEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tl_seq") @JsonIgnore private Long tlSeq;
    @Column(name = "mi_seq") private Long miSeq;
    @Column(name = "tp_seq") private Long tpSeq;
    @Column(name = "tp_name") private String tpName;
}
