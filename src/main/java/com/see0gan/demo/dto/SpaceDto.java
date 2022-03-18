package com.see0gan.demo.dto;

import com.see0gan.demo.entity.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class SpaceDto implements Serializable {

    private String spaceName;
    private SpaceType type;
    private Integer capacity;
    private String img1;
    private String img2;
    private String address2;
    private SpaceCustomTag tags;
    private SpaceFacility facility;
    private SpaceOpeningHour openingHour;

}
