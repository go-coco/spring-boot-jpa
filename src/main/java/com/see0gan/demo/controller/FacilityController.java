package com.see0gan.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.see0gan.space.entity.SpaceFacility;
import com.see0gan.space.service.FacilityService;

import lombok.RequiredArgsConstructor;

//@RestController
@RequestMapping(path="api/v1/spaces/facilities")
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    @GetMapping
    public List<SpaceFacility> findAllFacilities(){

        return facilityService.findAllFacilities();
    }

    @GetMapping(path="condition")
    public List<SpaceFacility> findAllFacilitiesHaving(@RequestParam boolean hasAirCon
                                                       ,@RequestParam boolean hasPrinter
                                                       ,@RequestParam boolean hasWifi
                                                       ,@RequestParam boolean hasParking ){

        return facilityService.findAllFacilitiesHaving(hasAirCon, hasPrinter, hasWifi, hasParking);
    }


    @GetMapping(path = "{facility_id}")
    public SpaceFacility findFacilityById(@PathVariable Long facility_id){

        return facilityService.findById(facility_id);
    }

    @PutMapping(path = "{facility_id}")
    public void updateFacilityById(@PathVariable Long facility_id
                                            ,@RequestBody SpaceFacility spaceFacility){

        facilityService.updateFacilityById(facility_id, spaceFacility);

    }

    @DeleteMapping(path = "{facility_id}")
    public void deleteFacilityById(@PathVariable Long facility_id){

        facilityService.deleteFacilityById(facility_id);
    }



}
