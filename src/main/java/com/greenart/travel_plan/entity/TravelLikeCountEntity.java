package com.greenart.travel_plan.entity;

import org.springframework.data.annotation.Immutable;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "여행지 번호" , example = "1")
    @Column(name = "tp_seq") private Long tpSeq;
    @Schema(description = "여행지 이름" , example = "강릉 경포대")
    @Column(name = "tp_name") private String tpName;
    @Schema(description = "좋아요 수" , example = "8")
    @Column(name = "likeplace") private Long likeplace;
    
}
