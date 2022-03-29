package com.see0gan.booking.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.see0gan.booking.entity.TimeSlot;

@Repository
public interface ScheduleRepository extends JpaRepository<TimeSlot, Long>, CustomBookingRepository{

	List<TimeSlot> findByBookingDate(LocalDate date);
	
	@Query(
			"SELECT ts"
			+ " FROM TimeSlot ts JOIN FETCH Booking b " //ON b.bookingId "//IN (ts.booking.bookingId) "
			+ " WHERE b.bookingId = ?1"
			
			)
	List<TimeSlot> findByBookingId(Long bookingId);
	
	List<TimeSlot> findByStartTime(LocalTime start);
	
//	@Query(
//			"SELECT ts"
//			+ " FROM TimeSlot ts"
//			+ " WHERE ts.space.spaceId = ?1 AND ts.bookingDate = ?2"
//			)
//	List<TimeSlot> findBySpaceIdAndBookingDate(Long spaceId, LocalDate date);
	
	
}
