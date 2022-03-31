package com.see0gan.space.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.see0gan.booking.entity.Booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SPACE")
@Where(clause = "deleted = false")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Space {

    @Id
    @SequenceGenerator(
            name = "space_sequence",
            sequenceName = "space_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "space_sequence"
    )
    private Long spaceId;
    
    
    private boolean deleted;
    private LocalDate regDate;
    
    private String spaceName;   
    private SpaceType type;
    private Integer capacity;    
    private String intro1;    
    private String intro2;    
    private Integer price;    
    @Embedded
    private RefundPolicy refund;
    
    // TODO : file upload service
    private String img1;    
    private String img2;
    
    // tags
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

    // relation-mapping
    
    @ManyToOne(
    		fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
          ,  optional = false
    )
    @JoinColumn(
            name = "host_id",
            referencedColumnName = "hostId",
            nullable=false
    )
    @JsonBackReference
    private Host host;
    
    
    @OneToOne( 
    		fetch = FetchType.LAZY,
    		mappedBy = "space"
    )
    private Location address;
    

    @OneToMany(
    		fetch = FetchType.LAZY,	mappedBy = "space"
    		)    
    @JsonManagedReference(value = "space-closure")
    private Set<TemporaryClosure> closures;
    
    
    @OneToMany(
    		fetch = FetchType.LAZY, mappedBy = "space"
    		)
    @JsonManagedReference(value = "space-booking")
    private Set<Booking> booking;
    
    
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
    
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Space other = (Space) obj;
		return Objects.equals(spaceId, other.spaceId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(spaceId);
	}
    
    
    
}
