package com.see0gan.demo.repository;

import com.see0gan.demo.dto.SpaceAd;
import com.see0gan.demo.entity.Space;
import com.see0gan.demo.entity.SpaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {

    List<Space> findAll();

    List<Space> findByType(SpaceType type);

    @Query(
            "SELECT new com.see0gan.demo.dto.SpaceAd(s.spaceId, s.spaceName, s.capacity, s.address2, s.price, s.tag)"
            +"FROM Space s"
    )
    List<SpaceAd> findAllForAds();
}
