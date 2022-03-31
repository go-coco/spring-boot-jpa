package com.see0gan.space.dto;

import com.see0gan.space.entity.SpaceType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpaceWithTime {

    private Long spaceId;
    private String spaceName;
    private SpaceType type;
    private String address;
//    private SpaceOpenTime openingHour;
}
