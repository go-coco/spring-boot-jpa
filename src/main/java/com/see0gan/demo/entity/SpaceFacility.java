package com.see0gan.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table( name = "facility")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SpaceFacility {

    @Id
    @SequenceGenerator(
            name="facility_sequence",
            sequenceName = "facility_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "facility_sequence"
    )
    private Long facilityId;
    private boolean hasAirConditioner;
    private boolean hasPrinter;
    private boolean hasFreeWifi;
    private boolean hasParkingLot;

    @JsonBackReference
    @OneToOne(
            cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
            , mappedBy = "facility"
    )
    private Space space;


    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }


    public Long getFacilityId() {
        return facilityId;
    }

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

    public Space getSpace() {
        return space;
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

    public void setSpace(Space space) {
        this.space = space;
    }


}
