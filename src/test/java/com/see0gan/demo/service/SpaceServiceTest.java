package com.see0gan.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.see0gan.space.dto.SpaceForm;
import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceType;
import com.see0gan.space.repository.SpaceRepository;
import com.see0gan.space.service.SpaceService;
import com.see0gan.space.service.SpaceServiceImpl;
import com.see0gan.utils.exception.ResourceNotFoundException;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class SpaceServiceTest {
	
	@Mock
	private SpaceRepository spaceRepository;

	private SpaceService underTest;
	@Autowired private TestEntityManager entityManager;
	
	@PersistenceContext private EntityManager em;
	
	@BeforeEach
	void setUp() {
//		underTest = new SpaceServiceImpl(spaceRepository,
//				//Persistence.createEntityManagerFactory("application.properties").createEntityManager());
//				em);
	}

	@Test
	void canGetAllSpaces() {
		// when
//		underTest.findSpaceByType(null);
//		
//		when(null).then(null);
//		
//		given().willReturn();
//		
//		never(), any();
//		
		// then
		verify(spaceRepository).findAByOrderByPriceAsc(null);
	
		assertThatThrownBy(() -> underTest.saveSpace(null))
					.isInstanceOf(ResourceNotFoundException.class)
					.hasMessageContaining("error");
	}
	
	
	@Test
	void canSaveSpaceInFoAtOnce() {
		
//		Host my = Host.builder()
//				.hostId(1L)
//				.name("dd") "dd@gmail.com", "000-555-4415");
//		
		
		
		Host host = Host.builder().hostId(1L).build();
		
	
	//	em.persist(host);
		
		SpaceForm spaceForm = new SpaceForm();
				spaceForm.setType(SpaceType.CONFERENCE);
				spaceForm.setHost(host);
				spaceForm.setSpaceName("palace");
				spaceForm.setPrice(150_000);
				spaceForm.setCapacity(100);
		//		spaceForm.getHost().setHostId(1L);
				
				underTest.saveSpace(spaceForm);
				
	}
	
	
	@Test
	void canHaveSameObject() {
		
		Space space = new Space();
		
		ArgumentCaptor<Space> spaceArgumentCaptor = ArgumentCaptor.forClass(Space.class);
		
		verify(spaceRepository).save(spaceArgumentCaptor.capture());
		
		Space capSpace = spaceArgumentCaptor.getValue();
		
		assertThat(capSpace).isEqualTo(space);
		
	}
}
