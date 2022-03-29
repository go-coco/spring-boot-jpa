package com.see0gan.demo.repository;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceCustomTag;
import com.see0gan.space.entity.SpaceType;
import com.see0gan.space.repository.SpaceCustomTagRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagRepositoryTest {


    @Autowired
    private SpaceCustomTagRepository repository;


    @Test
    public void saveTag(){

        Host richHost = Host.builder()
                .name("Liz")
                .email("Liz@hotel.com")
                .phone("0001442277871")
                .build();

        Space newSpace = Space.builder()
                .spaceName("L Party house")
                .type(SpaceType.PARTY)
         //       .address1("Seoul")
      //          .address2("gangnam station")
                .capacity(100)
                .img1("j/img1")
                .img2("j/img2")
                .intro1("This is my remote office!")
                .host(richHost)
                //    .tag(tags)
                .build();

        SpaceCustomTag tag = SpaceCustomTag.builder()
                .tag1("swimming pool")
                .tag2("free wifi")
                .tag3("parking")
      //          .space(newSpace)
                .build();


        repository.save(tag);
    }
    
    @Test
    public void getTags(){

        List<SpaceCustomTag> tags = repository.findAll();

        System.out.println("tags = " + tags);
    }
}
