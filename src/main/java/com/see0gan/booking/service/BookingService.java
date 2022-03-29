package com.see0gan.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.see0gan.booking.entity.Booking;
import com.see0gan.booking.repository.BookingRepository;
import com.see0gan.space.repository.SpaceRepository;
import com.see0gan.user.auth.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

	private final BookingRepository bookingRepository;
	private final SpaceRepository spaceRepository;
	private final AppUserRepository userRepository;

	
	public List<Booking> findAllBookingBySpaceId(String spaceId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> findAllBookingByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> findAllBookingByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Transactional
//	public void saveBooking(BookingForm newBooking) {
//		
//		
//	}

	
}
