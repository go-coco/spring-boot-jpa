package com.see0gan.demo.repository;


import com.see0gan.demo.entity.Host;
import com.see0gan.demo.entity.Space;
import com.see0gan.demo.entity.SpaceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HostRepositoryTest {

    @Autowired
    private HostRepository hostRepository;

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

   //     Host host = hostRepository.getHostByEmail("jimmy@test.com");


   //     System.out.println("host = " + host);
    }
}
