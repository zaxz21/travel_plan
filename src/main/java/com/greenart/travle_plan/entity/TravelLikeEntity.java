package com.greenart.travle_plan.entity;

import java.lang.annotation.Inherited;

import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @Schema(description = "여행지 좋아요 번호" , example = "1")
    @Column(name="tl_seq")      private Long tlSeq;
    
    @Schema(description = "여행지 번호" )
    @OneToOne @JoinColumn(name = "tl_tp_seq") TravelPlaceEntity travel;
    // @Column(name="tl_tp_seq")   private Long tlTpSeq;
    @Schema(description = "회원 번호" )
    @OneToOne @JoinColumn(name = "tl_mi_seq") MemberInfoEntity member;
    // @Column(name="tl_mi_seq")   private Long tlMiSeq;
}
