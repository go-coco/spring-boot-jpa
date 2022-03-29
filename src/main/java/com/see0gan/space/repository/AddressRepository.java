package com.see0gan.space.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.see0gan.space.entity.Location;

@Repository
public interface AddressRepository extends JpaRepository<Location, Long>{
	
	Page<Location> findAllByCityContaining(String city, Pageable pageable);
	

	
}
