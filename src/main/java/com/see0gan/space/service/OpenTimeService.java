package com.see0gan.space.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.see0gan.space.dto.SpaceWithTime;
import com.see0gan.space.entity.SpaceOpenTime;
import com.see0gan.space.repository.OpenTimeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OpenTimeService {

    private final OpenTimeRepository openTimeRepository;

    public List<SpaceOpenTime> getAllOpenTime(){

        return openTimeRepository.findAll();
    }

    public List<SpaceWithTime> findByOpeningTimeGreaterThanEqual(LocalTime openTime) {

    	return null;
      //  return openTimeRepository.findByOpeningTimeGreaterThanEqual(openTime);
    }

    public void updateOpenTime(Long timeId, LocalTime openTime, LocalTime closeTime) {

        openTimeRepository.updateOpenTime(timeId, openTime, closeTime);
    }
    
    public SpaceOpenTime findOpenTimeBySpaceId(Long spaceId) {
    	
    	return openTimeRepository.findBySpaceId(spaceId).get(); //.orElseThrow( () -> new ResourceNotFoundException("no result found with space" + spaceId));
    }
}
