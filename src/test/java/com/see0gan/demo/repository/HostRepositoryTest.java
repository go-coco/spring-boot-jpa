package com.see0gan.demo.repository;


import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceType;
import com.see0gan.space.repository.HostRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class HostRepositoryTest {

    @Autowired
    private HostRepository hostRepository;
    private TestEntityManager em;

    @Test
    public void SaveHost(){

        Host host =
                Host.builder()
                        .email("jimmy@test.com")
                        .name("jimmy")
                        .phone("01077779999")
                        .build();


        hostRepository.save(host);
    }

    @Test
    public void getHostByEmail(){

        Host host = hostRepository.getHostByEmail("Alice@gmail.com").get();//"jimmy@test.com");

        assertThat(host.getName()).isEqualTo("Alice");
        
   //     System.out.println("host = " + host);
    }
}
