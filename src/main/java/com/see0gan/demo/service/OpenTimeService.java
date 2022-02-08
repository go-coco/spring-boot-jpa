package com.see0gan.demo.service;

import com.see0gan.demo.dto.SpaceWithTime;
import com.see0gan.demo.entity.SpaceOpeningHour;
import com.see0gan.demo.repository.OpenTimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OpenTimeService {

    private final OpenTimeRepository openTimeRepository;

    public List<SpaceOpeningHour> getAllOpenTime(){

        return openTimeRepository.findAll();
    }

    public List<SpaceWithTime> findByOpeningTimeGreaterThanEqual(LocalTime openTime) {

        return openTimeRepository.findByOpeningTimeGreaterThanEqual(openTime);
    }

    public void updateOpenTime(Long timeId, LocalTime openTime, LocalTime closeTime) {

        openTimeRepository.updateOpenTime(timeId, openTime, closeTime);
    }
}
