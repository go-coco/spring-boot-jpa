package com.see0gan.space.dto;


import com.see0gan.space.entity.Location;

import lombok.AllArgsConstructor;
import lombok.Data;

// TODO: sorting & paging query by host premium membership

@Data
@AllArgsConstructor
public class SpaceAd {

    private Long spaceId;
    private String spaceName;
    private Integer capacity;
    private Location address;
    private Integer price;
    //private SpaceCustomTag tags;


}
