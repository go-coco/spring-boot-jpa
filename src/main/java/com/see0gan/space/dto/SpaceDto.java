package com.see0gan.space.dto;

import com.see0gan.space.entity.RefundPolicy;
import com.see0gan.space.entity.SpaceType;

import lombok.Data;

@Data
public class SpaceDto {

	private Long spaceId;
	private String spaceName;
	private SpaceType type;
	private Integer price;
	private Integer capacity;
    private String img1;
    private String img2;
    private String intro1;
    private String intro2;
    private RefundPolicy refund;
//    private String address2;
//    private SpaceCustomTag tags;
//    private SpaceFacility facility;
//    private SpaceOpenTime openingHour;

}
