package com.see0gan.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.see0gan.booking.entity.Booking;
import com.see0gan.booking.entity.TimeSlot;
import com.see0gan.booking.repository.BookingRepository;
import com.see0gan.booking.repository.ScheduleRepository;
import com.see0gan.space.entity.Guest;
import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceType;

@DataJpaTest
public class BookingRepoTest {
	
	@Autowired
	private BookingRepository underTest;
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ScheduleRepository repo;
	
	@Test
	public void itShouldReturnSpaceListWhenHostIdExists() {
		
		Guest guest = new Guest(1L, "Grace");
		
		Host host = Host.builder()
				.email("jimmy@test.com")
                .name("jimmy")
                .phone("01077779999")
                .build();
		
		entityManager.persist(host);
		
		Space space = Space.builder()
				   .spaceName("M studio")
                .type(SpaceType.STUDIO)
                .capacity(10)
                .price(10000)
                .img1("m/img1")
                .img2("m/img2")
                .intro1("This is my office!")
                .host(host)
                .build();
				

		Long spaceId = entityManager.persistAndFlush(space).getSpaceId();

		
		Booking b1 = Booking.builder()
				.user(guest)
				.space(space)
				.status("OPEN")
				.build();
		
		Long bookingId = underTest.save(b1).getBookingId();
		
		TimeSlot ts = TimeSlot.builder()
				.bookingDate(LocalDate.of(2022, 3, 27))
				.startTime(LocalTime.of(11, 0))
				.duration(2)
				.build();
		
		ts.addBooking(b1);
		
		
		repo.save(ts);
		
		List<Booking> find = underTest.findBySpaceId(spaceId);
		
		List<Booking> result = underTest.findByUserId(1L);
		
		List<TimeSlot> tlist = repo.findByBookingId(bookingId);
		
		assertThat(tlist).isNotEmpty();
		
		assertThat(result).isNotEmpty();
		assertThat(result.get(0).getSpace().getSpaceName()).isEqualTo("M studio");
	
		assertThat(find).isNotEmpty();
		assertThat(find.get(0).getStatus()).isEqualTo("OPEN");
	}

}
