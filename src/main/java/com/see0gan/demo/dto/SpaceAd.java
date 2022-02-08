package com.see0gan.demo.dto;


import com.see0gan.demo.entity.SpaceCustomTag;
import lombok.AllArgsConstructor;
import lombok.Data;

// TODO: sorting & paging query by host premium membership

@Data
@AllArgsConstructor
public class SpaceAd {

    private Long spaceId;
    private String spaceName;
    private Integer capacity;
    private String address2;
    private Integer price;
    private SpaceCustomTag tags;


}
