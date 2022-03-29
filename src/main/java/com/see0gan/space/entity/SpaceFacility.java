package com.see0gan.space.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table( name = "FACILITY")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SpaceFacility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facilityId;
	
	@OneToOne
	@JoinColumn(name = "SPACE_ID", referencedColumnName = "spaceId")
	@JsonBackReference
	private Space space;
	
	
    private boolean hasAirConditioner;
    private boolean hasPrinter;
    private boolean hasFreeWifi;
    private boolean hasParkingLot;

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
