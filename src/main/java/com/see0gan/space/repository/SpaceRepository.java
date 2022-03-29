package com.see0gan.space.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.see0gan.space.dto.SpaceAd;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceType;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {

    Page<Space> findAll(Pageable pageable);
    
    @Query(
            "SELECT s"
            +" FROM Space s JOIN FETCH Host h"
            +" ON h.hostId = :hostId"
            		
    )
    List<Space> findAllByHostId(Long hostId);
    
//    Page<Space> findBySpaceTypeContaining(SpaceType type, Pageable pageable);

    @Query(
            "SELECT new com.see0gan.space.dto.SpaceAd(s.spaceId, s.spaceName, s.capacity, s.address, s.price, s.tag)"
            +"FROM Space s"
    )
    List<SpaceAd> findAllForAds();
    
    
    Page<Space> findAByOrderByPriceAsc(Pageable pageable);
    
    Page<Space> findByOrderByPriceDesc(Pageable pageable);
    
   //  Space saveSpace(Space space);
}
