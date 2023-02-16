package com.greenart.travel_plan.entity;




import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "child_zone")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChildZoneEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "여행지역 번호" , example = "1")
    @Column(name = "cz_seq") private Long seq;
    @Schema(description = "여행지역" , example = "가평")
    @Column(name = "cz_name") private String name;
    @Schema(description = "영문명" , example = "GAPYEONG")
    @Column(name = "cz_eng_name") private String engname;
    @Schema(description = "여행지역 설명")
    @Column(name = "cz_latitude") private Double latitude;
    @Schema(description = "위도")
    @Column(name = "cz_longitude") private Double longitude;
    @Schema(description = "경도")
    @Column(name = "cz_explanation") private String explanation;
    @Schema(description = "이미지 번호" )
    @OneToOne @JoinColumn(name = "cz_ii_seq") ImgInfoEntity image;
    // @Column(name = "cz_ii_seq") private Long iiSeq;
    // @OneToOne(mappedBy = "zc_seq")
    // private Long zcSeq;
}
