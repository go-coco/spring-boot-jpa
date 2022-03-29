package com.see0gan.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.see0gan.booking.entity.Booking;
import com.see0gan.booking.entity.TimeSlot;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	Optional<Booking> findByBookingId(Long bookingId);
	
	List<Booking> findByStatus(String status);
	
	@Query(
			"SELECT b"
			+ " FROM Booking b"
			+ " WHERE b.user.userId = ?1")	
	List<Booking> findByUserId(Long userId);
	
	@Query(
			"SELECT b"
			+ " FROM Booking b"
			+ " WHERE b.space.spaceId = ?1")
	List<Booking> findBySpaceId(Long spacdId);
	
	//List<TimeSlot> findByBookingId(Long bookingId);
//	@Query(
//			"SELECT b "
//			+ " FROM Booking b")
	
//	List<Booking> findByDate();
	
//	@Query(
//			"SELECT b"
//			+ " FROM Booking b LEFT JOIN"
//			+ " SELECT h FROM Host h WHERE h.hostId = ?1 IN (h.space.spaceId)"
//			+ " ON b.spaceId IN (h.space.spaceId) " //WHERE h.hostId = ?1"
//			)
//	List<Booking> findByHostId(Long hostId);
	
	

}
