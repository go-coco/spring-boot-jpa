package com.see0gan.space.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.see0gan.space.dto.SpaceAd;
import com.see0gan.space.dto.SpaceForm;
import com.see0gan.space.entity.Space;

public interface SpaceService {
	
	
   // Page<Space> findSpacesByType(String type, Pageable pageable);

    Page<Space> getSpaces(Pageable pageable);

    //List<SpaceDto> getSpaceDto();

    Space getSpaceById(Long spaceId);

    void saveSpace(SpaceForm space);

    void deleteSpaceById(Long spaceId);

    void modifySpaceById(SpaceForm space);

    //List<SpaceAd> getSpaceAds();
}
