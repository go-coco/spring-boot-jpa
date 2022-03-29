package com.see0gan.space.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceFacility;
import com.see0gan.space.repository.FacilityRepository;
import com.see0gan.space.repository.SpaceRepository;
import com.see0gan.utils.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final SpaceRepository spaceRepository;
    
    
    public List<SpaceFacility> findAllFacilities() {

        return facilityRepository.findAll();
    }

    public SpaceFacility findById(Long facility_id) {

        return facilityRepository.findById(facility_id)
        		.orElseThrow(() -> new ResourceNotFoundException("no facility with id " + facility_id));

    }
    
    @Transactional
    public void saveFacility(Long spaceId, SpaceFacility facility) {
    	
    	Space savedSpace = spaceRepository.findById(spaceId)
    									.orElseThrow(() -> new ResourceNotFoundException("no space found with id " + spaceId));
    									
    	facility.setSpace(savedSpace);
    	
    	facilityRepository.save(facility);		
    	
    }

    @Transactional
    public void updateFacilityById(Long facility_id, SpaceFacility facility) {

        SpaceFacility option = facilityRepository.findById(facility_id).orElseThrow(() -> new ResourceNotFoundException("no facility with id " +facility_id));

        if(!Objects.equals(facility.hasAirConditioner(), option.hasAirConditioner())) option.setHasAirConditioner(facility.hasAirConditioner());
        if(!Objects.equals(facility.hasPrinter(), option.hasPrinter())) option.setHasPrinter(facility.hasPrinter());
        if(!Objects.equals(facility.hasFreeWifi(), option.hasFreeWifi())) option.setHasPrinter(facility.hasFreeWifi());
        if(!Objects.equals(facility.hasParkingLot(), option.hasParkingLot())) option.setHasParkingLot(facility.hasParkingLot());


         facilityRepository.updateById(
        		 facility_id,
                 option.hasAirConditioner(),
                 option.hasPrinter(),
                 option.hasFreeWifi(),
                 option.hasParkingLot());

    }

    private int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    @Transactional
    public void deleteFacilityById(Long facility_id) {

        facilityRepository.findById(facility_id)
        				.orElseThrow(() -> new ResourceNotFoundException("no facility with id " +facility_id));

        facilityRepository.deleteById(facility_id);

    }

    public List<SpaceFacility> findAllFacilitiesHaving(boolean hasAirCon, boolean hasPrinter, boolean hasWifi, boolean hasParking) {
        // TODO : to implement using dynamic where clause
        return null;

    }
}
