package com.see0gan.demo.controller;

import com.see0gan.demo.entity.SpaceFacility;
import com.see0gan.demo.service.FacilityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/spaces/facilities")
@AllArgsConstructor
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
