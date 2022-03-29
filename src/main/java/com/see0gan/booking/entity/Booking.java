package com.see0gan.booking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.see0gan.space.entity.Guest;
import com.see0gan.space.entity.Space;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@SequenceGenerator(name = "booking_sequence", sequenceName = "booking_sequence", allocationSize = 1)
	@GeneratedValue(generator = "booking_sequence", strategy = GenerationType.SEQUENCE)
	private Long bookingId;

	@ManyToOne( fetch = FetchType.LAZY,  cascade = CascadeType.ALL  )
	@JoinColumn(name = "TIME_ID", referencedColumnName = "timeId")
	private TimeSlot schedule;

	
	 @ManyToOne( fetch = FetchType.LAZY,  cascade = CascadeType.ALL  )
	 @JoinColumn(	name = "USER_ID", referencedColumnName = "userId" )  
	// @JsonManagedReference
	 private Guest user;
	 
	@ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL  )
	@JoinColumn( referencedColumnName = "spaceId" ) 
	@JsonBackReference(value = "space-booking")
	private Space space;
	

	private String status;
}
