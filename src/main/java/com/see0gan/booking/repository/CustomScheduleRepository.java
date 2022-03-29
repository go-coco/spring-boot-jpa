package com.see0gan.booking.repository;

import java.time.LocalDate;
import java.util.List;

import com.see0gan.booking.entity.BookingCalendar;

public interface CustomScheduleRepository {

	List<BookingCalendar> getCurrentMonthBooking(LocalDate refDate);
}
