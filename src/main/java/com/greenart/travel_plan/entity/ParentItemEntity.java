package com.greenart.travel_plan.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "parent_item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentItemEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "상위 준비물 번호" , example = "1")
    @Column(name = "pi_seq")    private Long   piSeq;
    @Schema(description = "상위 준비물 이름" , example = "세면/화장품")
    @Column(name = "pi_name")   private String piName;

    // @OneToMany(mappedBy = "pitem")
    // List<ItemConnectionEntity> itemConnections = new ArrayList<>();
}
