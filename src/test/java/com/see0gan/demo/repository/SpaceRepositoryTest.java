package com.see0gan.demo.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;
import com.see0gan.space.repository.SpaceRepository;

@DataJpaTest
public class SpaceRepositoryTest {

    @Autowired
    private SpaceRepository spaceRepository;
    @Autowired
    private TestEntityManager em;
    
    @AfterEach
    void tearDown() {
    	spaceRepository.deleteAll();
     }   
    
//    @Test
//    void itShouldCheckIfOpenTimeIsAvailable() {
//    	
//    	// given
//    	//Space space = new Space("test space", );
//    	//spaceRepository.save(space);
//    	// when
//    	spaceRepository.findAByOrderByPriceAsc(null) ;
//    	// then
//    }

    
    @Test
    public void getHost() {
    	
    	// given
    	Host host = Host.builder()
				.email("jimmy@test.com")
                .name("jimmy")
                .phone("01077779999")
                .build();
    	
    	Long hostId = em.persist(host).getHostId();
    	
    	Space s = Space.builder()
    				.spaceName("homey")
    				.deleted(false)
    				.host(host)
    	            .img1("home/img1")
    	            .img2("home/img2")
    	            .intro1("This is my second house!")
    	                        .build();
    	
    	Space s2 = Space.builder()
				.spaceName("ediya")
				.deleted(false)
				.host(host)
	            .img1("home/img1")
	            .img2("home/img2")
	            .intro1("This is cafe house!")       
	            .build();
    	
    	
    	host.addSpace(s);
    	host.addSpace(s2);
    	
    	em.persist(s);
    	em.persistAndFlush(s2);
    	
    	List<Space> actual = spaceRepository.findAllByHostId(hostId);
    	
    	assertThat(actual.size()).isEqualTo(2);
    }
    
//    @Test
//    public void updateSpaceAircon() {
//    	
//    	// given 
//    	Space s = Space.builder()
//				.spaceName("homey")
//				.deleted(false)
//				//.host(host)
//	            .img1("home/img1")
//	            .img2("home/img2")
//	            .intro1("This is my second house!")
//	            .build();
//    	
//    	Space newPlace = Space.builder().hasAirConditioner(true).build();
//    	
//    	Long spaceId = em.persistAndFlush(s).getSpaceId();
//    	
//    	spaceRepository.updateById(spaceId, newPlace);
//    	
//    	Space actual = em.find(Space.class, spaceId);
//    	
//    	assertThat(actual.hasAirConditioner()).isTrue();
//    }
    
    @Test
    public void deleteByIdWillReturn(){
    	
    	// given
    	Host host = Host.builder()
				.email("jimmy@test.com")
                .name("jimmy")
                .phone("01077779999")
                .build();
    	
    	em.persist(host);
    	
    	Space s = Space.builder()
    				.spaceName("homey")
    				.deleted(false)
    				.host(host)
    	            .img1("home/img1")
    	            .img2("home/img2")
    	            .intro1("This is my second house!")
    	                        .build();
   
    //	h = em.find(Host.class, 1L);
    	//s.setHost(host);
   
    	// TODO : look into the topic and implements hashcode() / equals()
    	//	host.addSpace(s);
    
    	
    	Long sid = em.persistAndFlush(s).getSpaceId();
    //	s = spaceRepository.save(s);
    	
    	spaceRepository.deleteById(sid);
    	
    	Space expected = em.find(Space.class, sid);
    	
    	assertThat(expected.isDeleted()).isTrue();
    	
    }

    //    Host host = hostRepository.getHostByEmail("Alice@gmail.com");


//        Host host2 = Host.builder()
//                .phone("0314444555")
//                .name("Alice")
//                .email("Alice@gmail.com")
//                .build();
//
//        Host host3 = Host.builder()
//                .name("Mia")
//                .email("mia@test.com")
//                .phone("031-8889-5612")
//                .build();
//
//        Space space =
//                Space.builder()
//                        .spaceName("churche")
//   //                     .address1("Seoul")
//     //                   .address2("sadang station")
//                        .capacity(1000)
//                        .img1("ch/img1")
//                        .img2("ch/img2")
//                        .build();
//
//        Space space1 =
//                Space.builder()
//                        .spaceName("homey")
//       //                 .address1("Incheon")
//        //                .address2("oido station")
//                        .capacity(10)
//                        .img1("home/img1")
//                        .img2("home/img2")
//                        .intro1("This is my second house!")
//                        .host(host3)
//                        .build();
//
//        Space space2 =
//                Space.builder()
//                        .spaceName("M studio")
//                        .type(SpaceType.STUDIO)
////                        .address1("Seoul")
////                        .address2("digital station")
//                        .capacity(10)
//                        .img1("m/img1")
//                        .img2("m/img2")
//                        .intro1("This is my office!")
//                        .host(host2)
//                        .build();
//
//
//        spaceRepository.save(space1);
//    }
//
//    @Test
//    public void saveSpaceCustomTag(){
//
//        Host richHost = Host.builder()
//                .name("Abba")
//                .email("abba@krasse.com")
//                .phone("0001112277871")
//                .build();
//
//        SpaceCustomTag tags = SpaceCustomTag.builder()
//                .tag1("clean")
//                .tag2("24/7 open")
//                .tag3("coffee machine")
//                .build();
//
//        Space newSpace = Space.builder()
//                .spaceName("A office")
//                .type(SpaceType.STUDIO)
//           //     .address1("Seoul")
//      //          .address2("gangnam station")
//                .capacity(100)
//                .img1("j/img1")
//                .img2("j/img2")
//                .intro1("This is my remote office!")
//                .host(richHost)
//            //    .tag(tags)
//                .build();
//
//        spaceRepository.save(newSpace);
//    }
//
//    @Test
//    public void printSpace(){
//
//        List<Space> spaces = spaceRepository.findAll();
//
//        System.out.println("spaces = " + spaces);
//    }
//
//    @Test
//    public void addNewInfos(){
//
//        SpaceCustomTag tags = SpaceCustomTag.builder()
//                .tag1("new space open")
//                .tag2("informative")
//                .tag3("fully equipped")
//                .build();
//
//        Host newHost =  Host.builder()
//                .name("Joe")
//                .email("joeN@hello.com")
//                .phone("010289756126")
//                .build();
//
//        SpaceFacility facility = SpaceFacility.builder()
//                .hasAirConditioner(true)
//                .hasFreeWifi(true)
//                .hasParkingLot(true)
//                .hasParkingLot(false)
//                .build();
//
//        RefundPolicy refund = RefundPolicy.builder()
//                .before30(100)
//                .before7(50)
//                .before1(0)
//                .build();
//
//        SpaceOpenTime time = SpaceOpenTime.builder()
//                .openTime(LocalTime.of(9, 30))
//                .closeTime(LocalTime.of(23, 00))
//                .holiday("MON")
//                .build();
//
//        Space space = Space.builder()
//                .spaceName("Game Station")
//                .type(SpaceType.PARTY)
//                .tag(tags)
//                .host(newHost)
//                .facility(facility)
//       //         .address1("Ansan")
//        //        .address2("Banwol")
//                .intro1("hello guys, this is your dream PC room")
//                .intro2("free drink for newbie")
//                .img1("pub/img1")
//                .img2("pub/img2")
//                .capacity(70)
//                .refund(refund)
//                .openingHour(time)
//                .regDate(LocalDate.now())
//                .build();
//
//        spaceRepository.save(space);
//    }
//
//    @Test
//    public void findByType(){
//
//        List<Space> list = null;
//    //    spaceRepository.findByType(SpaceType.STUDIO);
//
//        System.out.println(list.size());
//        System.out.println("list = " + list);
//    }
}
