package com.see0gan.demo.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceOpenTime;
import com.see0gan.space.entity.SpaceType;
import com.see0gan.space.entity.TemporaryClosure;
import com.see0gan.space.repository.OpenTimeRepository;
import com.see0gan.space.repository.TemporaryClosureRepository;

@DataJpaTest
public class OpenTimeRepositoryTest {
	
	@Autowired
	private OpenTimeRepository underTest;
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private TemporaryClosureRepository temporaryClosureRepo;
	
	@BeforeEach
	public void setUp() {
		
	
	}
	
	@Test
	public void itShouldReturnOpenTimeWithSpaceId() {
		
		// given
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
		entityManager.clear();
		
		SpaceOpenTime sot = SpaceOpenTime.builder()				 
					.openTime(LocalTime.of(9, 0))
					.closeTime(LocalTime.of(18, 0))
					.holiday("MON")
					.space(space)
					.build();

		underTest.save(sot);
		
	
		// when
		
		Optional<SpaceOpenTime> savedOpenTime = underTest.findBySpaceId(spaceId);
		// then
		
		assertThat(savedOpenTime).isPresent();
		assertThat(savedOpenTime.get().getHoliday()).isEqualTo("MON");
		assertThat(savedOpenTime.get().getOpenTime()).isEqualTo(LocalTime.of(9, 0));
		
	}
	
	
	
	@Test
	public void itShouldhave() {
		
		// 	// given
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
		entityManager.clear();
		
		SpaceOpenTime sot = SpaceOpenTime.builder()				 
					.openTime(LocalTime.of(9, 0))
					.closeTime(LocalTime.of(18, 0))
					.holiday("MON")
					.space(space)
					.build();

		underTest.save(sot);
	
		ArrayList<String> days = new ArrayList<>();
		
		days.add("TUE");
		days.add("FRI");
		
		
		List<SpaceOpenTime> avaliable = underTest.
						findByHolidayNotIn(days);
	
		assertThat(avaliable).isNotEmpty();
		assertThat(avaliable.size()).isGreaterThan(0);
	}
	
	@Test
	public void itShouldNotClosed() {
	
		// given
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
			//	entityManager.clear();
				
				TemporaryClosure tc = TemporaryClosure
						.builder()
						.date(LocalDate.of(2022, 3, 15))
						.time(LocalTime.of(0, 0))
						.duration(24)
						.space(space)
						.build();
				
				temporaryClosureRepo.save(tc);
				
				//when
				List<TemporaryClosure> result = temporaryClosureRepo.findBySpaceId(spaceId);
				
		//		temfindByDate(LocalDate.of(2022, 3, 15));
				
//				assertThat(result).isNotEmpty();
				assertThat(result.get(0).getClourseId()).isEqualTo(1L);
				
		
	}
	
}