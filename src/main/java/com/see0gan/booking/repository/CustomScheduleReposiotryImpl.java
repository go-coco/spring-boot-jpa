package com.see0gan.booking.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.see0gan.booking.entity.Booking;
import com.see0gan.booking.entity.BookingCalendar;

public class CustomScheduleReposiotryImpl implements CustomScheduleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<BookingCalendar> getCurrentMonthBooking(LocalDate refDate) {
	
		em.find(Booking.class, 1);
		
		return null;
	}
	
	
	
}
