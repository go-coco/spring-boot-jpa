package com.see0gan.demo.service;

import com.see0gan.demo.dto.SpaceAd;
import com.see0gan.demo.dto.SpaceDto;
import com.see0gan.demo.entity.Space;

import java.util.List;

public interface SpaceService {
    List<Space> findSpaceByType(String type);

    List<Space> getSpaces();

    List<SpaceDto> getSpaceDto();

    Space getSpaceById(Long spaceId);

    String addNewSpace(Space space);

    void deleteSpaceById(Long spaceId);

    void modifySpaceById(Long spaceId, Space space);

    List<SpaceAd> getSpaceAds();
}
