package com.see0gan.space.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.see0gan.space.entity.RefundPolicy;
import com.see0gan.space.entity.SpaceType;

import lombok.Data;

@Data
public class SpaceDto {

	private Long spaceId;
	private String spaceName;
	private SpaceType type;
	private Integer price;
	private Integer capacity;
    private String img1;
    private String img2;
    private String intro1;
    private String intro2;
    private RefundPolicy refund;
    //tags
    private String tag1;
    private String tag2;
    private String tag3;
    // space_facility
    private boolean hasAirConditioner;
    private boolean hasPrinter;
    private boolean hasFreeWifi;
    private boolean hasParkingLot;
    // space_open_time
    private LocalTime openTime;
    private LocalTime closeTime;
    private String holiday; 

    
    @JsonProperty("hasAirConditioner")
    public boolean hasAirConditioner() {
        return hasAirConditioner;
    }
    @JsonProperty("hasPrinter")
    public boolean hasPrinter() {
        return hasPrinter;
    }
    @JsonProperty("hasFreeWifi")
    public boolean hasFreeWifi() {
        return hasFreeWifi;
    }
    @JsonProperty("hasParkingLot")
    public boolean hasParkingLot() {
        return hasParkingLot;
    }

    public void setHasAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }

    public void setHasPrinter(boolean hasPrinter) {
        this.hasPrinter = hasPrinter;
    }

    public void setHasFreeWifi(boolean hasFreeWifi) {
        this.hasFreeWifi = hasFreeWifi;
    }

    public void setHasParkingLot(boolean hasParkingLot) {
        this.hasParkingLot = hasParkingLot;
    }

}
