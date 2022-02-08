package com.see0gan.demo.service;

import com.see0gan.demo.entity.SpaceFacility;
import com.see0gan.demo.exception.ResourceNotFoundException;
import com.see0gan.demo.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public List<SpaceFacility> findAllFacilities() {

        return facilityRepository.findAll();
    }

    public SpaceFacility findById(Long facility_id) {

        return facilityRepository.findById(facility_id).orElseThrow(() -> new ResourceNotFoundException("no facility with id " + facility_id));

    }

    @Transactional
    public void updateFacilityById(Long facility_id, SpaceFacility facility) {

        SpaceFacility option = facilityRepository.findById(facility_id).orElseThrow(() -> new ResourceNotFoundException("no facility with id " +facility_id));

        if(!Objects.equals(facility.hasAirConditioner(), option.hasAirConditioner())) option.setHasAirConditioner(facility.hasAirConditioner());
        if(!Objects.equals(facility.hasPrinter(), option.hasPrinter())) option.setHasPrinter(facility.hasPrinter());
        if(!Objects.equals(facility.hasFreeWifi(), option.hasFreeWifi())) option.setHasPrinter(facility.hasFreeWifi());
        if(!Objects.equals(facility.hasParkingLot(), option.hasParkingLot())) option.setHasParkingLot(facility.hasParkingLot());


         facilityRepository.updateById(facility_id,
                 option.hasAirConditioner(),
                 option.hasPrinter(),
                option.hasFreeWifi(),
                option.hasParkingLot());

    }

    private int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    public void deleteFacilityById(Long facility_id) {

        SpaceFacility found = facilityRepository.findById(facility_id).orElseThrow(() -> new ResourceNotFoundException("no facility with id " +facility_id));

        facilityRepository.deleteById(facility_id);

    }

    public List<SpaceFacility> findAllFacilitiesHaving(boolean hasAirCon, boolean hasPrinter, boolean hasWifi, boolean hasParking) {
        // TODO : to implement using dynamic where clause
        return null;

    }
}
