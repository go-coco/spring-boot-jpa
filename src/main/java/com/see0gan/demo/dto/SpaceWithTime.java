package com.see0gan.demo.dto;

import com.see0gan.demo.entity.SpaceOpeningHour;
import com.see0gan.demo.entity.SpaceType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpaceWithTime {

    private Long spaceId;
    private String spaceName;
    private SpaceType type;
    private String address2;
    private SpaceOpeningHour openingHour;
}
