package com.see0gan.demo.dto;

import com.see0gan.demo.entity.SpaceCustomTag;
import lombok.Data;

@Data
public class SpaceWithTag {

    private Long spaceId;
    private String spaceName;
    private Integer price;
    private String address2;
    private SpaceCustomTag tags;

    public SpaceWithTag(Long spaceId, String spaceName, Integer price, String address2, SpaceCustomTag tags) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.price = price;
        this.address2 = address2;
        this.tags = tags;
    }
}