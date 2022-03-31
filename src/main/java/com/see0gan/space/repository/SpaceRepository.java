package com.see0gan.space.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.see0gan.space.entity.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {

    Page<Space> findAll(Pageable pageable);
    
    @Query(
            "SELECT s"
            +" FROM Space s JOIN FETCH Host h"
            +" ON h.hostId = :hostId"
            		
    )
    List<Space> findAllByHostId(Long hostId);
    
    @Modifying
    @Query(
    		"UPDATE Space s"
    		+ " SET s.deleted = true"
    		+ " WHERE s.spaceId = ?1"
    		)
    void deleteById(Long id);

    // query map?
    @Modifying
    @Query(
    		"UPDATE Space s"
    		+ " SET"
    		+ " s.spaceName = :#{#uSpace.spaceName}"
    		+ " s.type = :#{#uSpace.type}"
    		+ " s.price = :#{#uSpace.price}"
    		+ " s.capacity = :#{#uSpace.capacity}"
    		+ " s.intro1 = :#{#uSpace.intro1}"
    		+ " s.intro2 = :#{#uSpace.intro2}"
    		+ " s.refund = :#{#uSpace.refund}"
    		+ "	s.hasAirConditioner = :#{#uSpace.hasAirConditioner}"
    		+ " s.hasPrinter = :#{#uSpace.hasPrinter}"
    		+ " s.hasFreeWifi = :#{#uSpace.hasFreeWifi}"
    		+ " s.hasParkingLot = :#{#uSpace.hasParkingLot}"
    		+ " s.tag1 = :#{#uSpace.tag1}"
    		+ "	s.tag2 = :#{#uSpace.tag2}"
    		+ " s.tag3 = :#{#uSpace.tag3}"
    		+ "	s.openTime = :#{#uSpace.openTime}"
    		+ " s.closeTime = :#{#uSpace.closeTime}"
    		+ " s.holiday = :#{#uSpace.holiday}" 		
    		+ " WHERE s.spaceId = ?1")
   void updateById(Long id, @Param("uSpace") Space uSpace);
   
    
   //  Space saveSpace(Space space);
}
