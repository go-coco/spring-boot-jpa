package com.see0gan.space.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Space;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {

    Optional<Host> getHostByEmail(String email);
    
    List<Space> findSpaceByHostId(Long hostId);
}
