package com.see0gan.space.dto;

import com.see0gan.space.entity.Location;
import com.see0gan.space.entity.SpaceCustomTag;

import lombok.Data;

@Data
public class SpaceWithTag {

    private Long spaceId;
    private String spaceName;
    private Integer price;
    private Location address;
    private SpaceCustomTag tags;

    public SpaceWithTag(Long spaceId, String spaceName, Integer price, Location address, SpaceCustomTag tags) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.price = price;
        this.address = address;
        this.tags = tags;
    }
}