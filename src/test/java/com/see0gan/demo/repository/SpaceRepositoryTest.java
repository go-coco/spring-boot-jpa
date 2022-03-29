package com.see0gan.demo.repository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.RefundPolicy;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceCustomTag;
import com.see0gan.space.entity.SpaceFacility;
import com.see0gan.space.entity.SpaceOpenTime;
import com.see0gan.space.entity.SpaceType;
import com.see0gan.space.repository.HostRepository;
import com.see0gan.space.repository.SpaceRepository;

@DataJpaTest
public class SpaceRepositoryTest {

    @Autowired
    private SpaceRepository spaceRepository;
    private HostRepository hostRepository;
    
    @AfterEach
    void tearDown() {
    	spaceRepository.deleteAll();
     }   
    
    @Test
    void itShouldCheckIfOpenTimeIsAvailable() {
    	
    	// given
    	//Space space = new Space("test space", );
    	//spaceRepository.save(space);
    	// when
    	spaceRepository.findAByOrderByPriceAsc(null) ;
    	// then
    }

    @Test
    public void saveSpace(){

    //    Host host = hostRepository.getHostByEmail("Alice@gmail.com");


        Host host2 = Host.builder()
                .phone("0314444555")
                .name("Alice")
                .email("Alice@gmail.com")
                .build();

        Host host3 = Host.builder()
                .name("Mia")
                .email("mia@test.com")
                .phone("03188895612")
                .build();

        Space space =
                Space.builder()
                        .spaceName("churche")
   //                     .address1("Seoul")
     //                   .address2("sadang station")
                        .capacity(1000)
                        .img1("ch/img1")
                        .img2("ch/img2")
                        .build();

        Space space1 =
                Space.builder()
                        .spaceName("homey")
       //                 .address1("Incheon")
        //                .address2("oido station")
                        .capacity(10)
                        .img1("home/img1")
                        .img2("home/img2")
                        .intro1("This is my second house!")
                        .host(host3)
                        .build();

        Space space2 =
                Space.builder()
                        .spaceName("M studio")
                        .type(SpaceType.STUDIO)
//                        .address1("Seoul")
//                        .address2("digital station")
                        .capacity(10)
                        .img1("m/img1")
                        .img2("m/img2")
                        .intro1("This is my office!")
                        .host(host2)
                        .build();


        spaceRepository.save(space1);
    }

    @Test
    public void saveSpaceCustomTag(){

        Host richHost = Host.builder()
                .name("Abba")
                .email("abba@krasse.com")
                .phone("0001112277871")
                .build();

        SpaceCustomTag tags = SpaceCustomTag.builder()
                .tag1("clean")
                .tag2("24/7 open")
                .tag3("coffee machine")
                .build();

        Space newSpace = Space.builder()
                .spaceName("A office")
                .type(SpaceType.STUDIO)
           //     .address1("Seoul")
      //          .address2("gangnam station")
                .capacity(100)
                .img1("j/img1")
                .img2("j/img2")
                .intro1("This is my remote office!")
                .host(richHost)
            //    .tag(tags)
                .build();

        spaceRepository.save(newSpace);
    }

    @Test
    public void printSpace(){

        List<Space> spaces = spaceRepository.findAll();

        System.out.println("spaces = " + spaces);
    }

    @Test
    public void addNewInfos(){

        SpaceCustomTag tags = SpaceCustomTag.builder()
                .tag1("new space open")
                .tag2("informative")
                .tag3("fully equipped")
                .build();

        Host newHost =  Host.builder()
                .name("Joe")
                .email("joeN@hello.com")
                .phone("010289756126")
                .build();

        SpaceFacility facility = SpaceFacility.builder()
                .hasAirConditioner(true)
                .hasFreeWifi(true)
                .hasParkingLot(true)
                .hasParkingLot(false)
                .build();

        RefundPolicy refund = RefundPolicy.builder()
                .before30(100)
                .before7(50)
                .before1(0)
                .build();

        SpaceOpenTime time = SpaceOpenTime.builder()
                .openTime(LocalTime.of(9, 30))
                .closeTime(LocalTime.of(23, 00))
                .holiday("MON")
                .build();

        Space space = Space.builder()
                .spaceName("Game Station")
                .type(SpaceType.PARTY)
                .tag(tags)
                .host(newHost)
                .facility(facility)
       //         .address1("Ansan")
        //        .address2("Banwol")
                .intro1("hello guys, this is your dream PC room")
                .intro2("free drink for newbie")
                .img1("pub/img1")
                .img2("pub/img2")
                .capacity(70)
                .refund(refund)
                .openingHour(time)
                .regDate(LocalDate.now())
                .build();

        spaceRepository.save(space);
    }

    @Test
    public void findByType(){

        List<Space> list = null;
    //    spaceRepository.findByType(SpaceType.STUDIO);

        System.out.println(list.size());
        System.out.println("list = " + list);
    }
}
