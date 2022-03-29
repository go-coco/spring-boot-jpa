package com.see0gan.booking.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.see0gan.booking.entity.Booking;
import com.see0gan.booking.service.BookingService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(path ="api/v1/booking")
public class BookingController {

	private BookingService bookingService;
	
//	public void registerBooking(@RequestBody BookingForm newBooking) {
//		bookingService.saveBooking(newBooking);
//	}
	
	public List<Booking> findAllBookingByUserId(@RequestParam String userId){
			return bookingService.findAllBookingByUserId(userId);
	}
	public List<Booking> findAllBookingBySpaceId(@RequestParam String spaceId){
		return bookingService.findAllBookingBySpaceId(spaceId);
	}
	public List<Booking> findAllBookingByStatus(@RequestParam String status){
		return bookingService.findAllBookingByStatus(status);
	}
	
	@Data
	public class BookingForm{
		private Long userId;
		private Long spaceId;
		private Long timeId;
	}
}
