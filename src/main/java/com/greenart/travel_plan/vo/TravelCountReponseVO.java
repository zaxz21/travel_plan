package com.greenart.travel_plan.vo;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.greenart.travel_plan.entity.TravelLikeCountEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelCountReponseVO {
@Schema (description = "상태" , example = "true")
 private Boolean status;
@Schema (description = "메세지" , example = " 성공")
 private String message;
 @Schema (description = "code" , example = "HttpStatus.OK")
 private HttpStatusCode code;
@Schema (description = "List" )
 private List<TravelLikeCountEntity>result;

}
