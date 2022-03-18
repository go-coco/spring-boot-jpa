package com.see0gan.demo.repository;

import com.see0gan.demo.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {

    Optional<Host> getHostByEmail(String email);
}
