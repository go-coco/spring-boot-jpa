package com.see0gan.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Location;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceType;
import com.see0gan.space.repository.SearchRepository;

@DataJpaTest
public class SearchRepositoryTest {
	
	@Autowired
	private SearchRepository searchRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void priceByOrder() {
		
		// given
	
		Host host = Host.builder().name("grace").email("grace@naver.com").build();
		entityManager.persist(host);
		
		List<Space> spaces = new ArrayList<>();
	
		spaces.add(Space.builder().host(host).type(SpaceType.valueOf("PRACTICE")).price(150_000).build());
		spaces.add(Space.builder().host(host).type(SpaceType.valueOf("STUDIO")).price(75_000).build());
		spaces.add(Space.builder().host(host).type(SpaceType.valueOf("PRACTICE")).price(3_000).build());
		spaces.add(Space.builder().host(host).type(SpaceType.valueOf("CONFERENCE")).price(12_000).build());
		spaces.add(Space.builder().host(host).type(SpaceType.valueOf("PRACTICE")).price(29_000).build());
	
	
		
		spaces.stream().forEach( space -> entityManager.persist(space));
		
		entityManager.flush();
		
		// when 
		
		Page<Space> actual = searchRepository.findByOrderByPriceDesc(PageRequest.of(0, 2));
		Page<Space> test = searchRepository.findSpacesByType(SpaceType.valueOf("PRACTICE"), PageRequest.of(0, 2));
		// then
		

		assertThat(test.getTotalPages()).isEqualTo(2);
//		assertThat(actual.getContent().get(0).getPrice()).isEqualTo(150000);
		
		
	}
	
	@Test
	public void itShouldReturnSpaceWhenTagsMatch() {
		
		// given
	
		Host host = Host.builder().name("grace").email("grace@naver.com").build();
		entityManager.persist(host);
		
		List<Space> spaces = new ArrayList<>();
	
		spaces.add(Space.builder().host(host).tag1("dance").tag2("clean").tag3("강남역 도보 3분").type(SpaceType.valueOf("PRACTICE")).price(150_000).build());
		spaces.add(Space.builder().host(host).tag1("웨딩촬영가능").tag2("아기자기").tag3("행사").type(SpaceType.valueOf("STUDIO")).price(75_000).build());
		spaces.add(Space.builder().host(host).tag1("거울").type(SpaceType.valueOf("PRACTICE")).price(3_000).build());
		spaces.add(Space.builder().host(host).tag1("쾌적한").tag2("직장인").type(SpaceType.valueOf("CONFERENCE")).price(12_000).build());
		spaces.add(Space.builder().host(host).tag1("음향시설").type(SpaceType.valueOf("PRACTICE")).price(29_000).build());
	
	
		
		spaces.stream().forEach( space -> entityManager.persist(space));
		
		entityManager.flush();
		
		// when 
		
		Page<Space> actual = searchRepository.getSpacesByTag("직장인", PageRequest.of(0, 2));
//		Page<Space> test = searchRepository.findSpacesByType(SpaceType.valueOf("PRACTICE"), PageRequest.of(0, 2));
		// then
		

//		assertThat(test.getTotalPages()).isEqualTo(2);
		assertThat(actual.getContent().get(0).getPrice()).isEqualTo(12000);
		
		
	}
	

	@Test
	public void itShouldFindSpaceCityMatches() {
		
		// given
	
		Host host = Host.builder().name("grace").email("grace@naver.com").build();
		entityManager.persist(host);
		
		List<Space> spaces = new ArrayList<>();
	
		spaces.add(Space.builder().host(host).tag1("dance").tag2("clean").tag3("강남역 도보 3분").type(SpaceType.valueOf("PRACTICE")).price(150_000).build());
		spaces.add(Space.builder().host(host).tag1("웨딩촬영가능").tag2("아기자기").tag3("행사").type(SpaceType.valueOf("STUDIO")).price(75_000).build());
		spaces.add(Space.builder().host(host).tag1("거울").type(SpaceType.valueOf("PRACTICE")).price(3_000).build());
		spaces.add(Space.builder().host(host).tag1("쾌적한").tag2("직장인").type(SpaceType.valueOf("CONFERENCE")).price(12_000).build());
		spaces.add(Space.builder().host(host).tag1("음향시설").type(SpaceType.valueOf("PRACTICE")).price(29_000).build());
	
//		spaces.stream().forEach( space -> {entityManager.persist(space); });
//		
		
		long counter = 0;
		for(Space space : spaces) {
			Location l = new Location (counter, "서울 강남대로 "+counter, "서울", "강남대로", "15492", space);
			entityManager.persist(l);
			space.setAddress(l);
			
		}
		
		
		
		
		spaces.get(0).getAddress().setCity("안산");//entityManager.find(Space.class, 1L);	
		//change1.getHost();//getAddress().setCity("안산");		
	//	Space change2 = entityManager.find(Space.class, 2L);
		spaces.get(1).getAddress().setCity("수원");
		
		spaces.stream().forEach( space -> {entityManager.persist(space); });
			
		
		entityManager.flush();
		
	
	
	Page<Space> actual = searchRepository.getSpacesByLocation("서울", PageRequest.of(0, 2));

	assertThat(actual.getTotalPages()).isEqualTo(2);
	assertThat(actual.getContent().get(0).getAddress().getCity()).isNotEqualTo("안산");
	}
	
	@Test
	public void itShouldFindSpaceFacilityMatches() {
		
		// given
	
		Host host = Host.builder().name("grace").email("grace@naver.com").build();
		entityManager.persist(host);
		
		List<Space> spaces = new ArrayList<>();
	
		spaces.add(Space.builder().host(host).hasPrinter(true).tag1("dance").tag2("clean").tag3("강남역 도보 3분").type(SpaceType.valueOf("PRACTICE")).price(150_000).build());
		spaces.add(Space.builder().host(host).hasFreeWifi(true).hasParkingLot(true).tag1("웨딩촬영가능").tag2("아기자기").tag3("행사").type(SpaceType.valueOf("STUDIO")).price(75_000).build());
		spaces.add(Space.builder().host(host).hasAirConditioner(true).tag1("거울").type(SpaceType.valueOf("PRACTICE")).price(3_000).build());
		spaces.add(Space.builder().host(host).hasFreeWifi(true).tag1("쾌적한").tag2("직장인").type(SpaceType.valueOf("CONFERENCE")).price(12_000).build());
		spaces.add(Space.builder().host(host).hasAirConditioner(true).tag1("음향시설").type(SpaceType.valueOf("PRACTICE")).price(29_000).build());
	
		spaces.stream().forEach( space -> {entityManager.persist(space); });

		//when
		
		Page<Space> actual = searchRepository
									.getSpacesByFacilitiesHaving(true, false, false, false,
											PageRequest.of(0, 1, Sort.by("price").ascending()));//.and(Sort.by()....);
		
		assertThat(actual.getTotalPages()).isEqualTo(2);
	}
	
}
