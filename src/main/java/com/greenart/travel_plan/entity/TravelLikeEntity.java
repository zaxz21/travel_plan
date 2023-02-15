package com.greenart.travel_plan.entity;



import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
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
    // public TravelLikeEntity(Object tlSeq2, Long tpseq, Long miseq) {
    // }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "여행지 좋아요 번호" , example = "1")
    @Column(name="tl_seq")      private Long tlSeq;
    @Schema(description = "여행지 번호" )
    @OneToOne @JoinColumn(name = "tl_tp_seq")  TravelPlaceEntity travel;
    // @Column(name="tl_tp_seq")   private Long tlTpSeq;
    @Schema(description = "회원 번호" )
    @OneToOne @JoinColumn(name = "tl_mi_seq") MemberInfoEntity member;
    // @Column(name="tl_mi_seq")   private Long tlMiSeq;

    public void setTravel(TravelPlaceEntity travel) {
        this.travel = travel;
    }
    public void setMember(MemberInfoEntity member) {
        this.member = member;
    }
    public static TravelLikeEntity LikeEntity(TravelPlaceEntity travel,MemberInfoEntity member ){
        TravelLikeEntity travellike = new TravelLikeEntity();
        travellike.setTravel(travel);
        travellike.setMember(member);

        return travellike;
    }
    
    // public TravelLikeEntity(TravelLikeEntity entity) {
    //     this.tlSeq = entity.getTlSeq();
    //     this.travel =entity.getTravel().getTpSeq();
    //     this.member = entity.getMember();
        
    // }


}
