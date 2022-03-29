package com.see0gan.booking.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCHEDULE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {

	@Id
	@GeneratedValue
	private Long timeId;
	
	@OneToMany(
			mappedBy = "schedule"
		)
	private Set<Booking> booking;
	private LocalDate bookingDate;
	private LocalTime startTime;
	private int duration;
	
	 public Set<Booking> getBooking(){
	    	return this.booking;
	 }
	 
	 public void addBooking(Booking b){
	       if(booking==null)
	          booking = new HashSet<>();
	       booking.add(b);
	 }
}
