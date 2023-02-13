package com.greenart.travel_plan.entity;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travel_like_count")
@Immutable
@Entity
public class TravelLikeCountEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tp_seq") private Long tpSeq;
    @Column(name = "tp_name") private String tpName;
    @Column(name = "likeplace") private Long likeplace;
    
}
