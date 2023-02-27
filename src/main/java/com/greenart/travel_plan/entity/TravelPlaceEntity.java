package com.greenart.travel_plan.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travel_place")
@Entity
@Builder
public class TravelPlaceEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "여행지 번호" , example = "1")
    @Column(name = "tp_seq") private Long tpSeq;
    @Schema(description = "여행지 이름" , example = "강릉 경포대")
    @Column(name = "tp_name") private String tpName;
    @Schema(description = "여행지 주소" , example = "강원도 강릉시 경포로 365")
    @Column(name = "tp_adress") private String tpAdress;
    @Schema(description = "여행지 위도" , example = "128.8965126086")
    @Column(name = "tp_latitude") private Double tpLatitude;
    @Schema(description = "여행지 경도" , example = "37.7955691591")
    @Column(name = "tp_longitude") private Double tpLongitude;
    @Schema(description = "여행지 연결 테이블 번호" )
    @Column(name = "tp_zc_seq") private Long tpZcSeq;
    @Schema(description = "이미지 URI" )
    @Column(name = "tp_image") private String tpImage;
    @Schema(description = "여행지 종류",example = "1:명소/2:호텔3:식당" )
    @Column(name = "tp_type") private Integer tpType;

    // @Schema(description = "여행일정")
    // @Column(name="ts_tp_seq")
    // @OneToMany(mappedBy = "travelPlace")
    // private List<TravelScheduleEntity> tpSchedule = new ArrayList<>();
    
}
