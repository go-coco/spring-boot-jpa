package com.see0gan.demo.service;

import com.see0gan.demo.entity.SpaceCustomTag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpaceWithTag {

    private String spaceId;
    private String spaceName;
    private Integer price;
    private String address2;
    private SpaceCustomTag tags;


}
