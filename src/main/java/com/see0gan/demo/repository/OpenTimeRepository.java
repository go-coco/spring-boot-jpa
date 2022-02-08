package com.see0gan.demo.repository;

import com.see0gan.demo.dto.SpaceWithTime;
import com.see0gan.demo.entity.SpaceOpeningHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface OpenTimeRepository extends JpaRepository<SpaceOpeningHour, Long> {

    @Query(
            "SELECT new com.see0gan.demo.dto.SpaceWithTime(h.space.spaceId, h.space.spaceName, h.space.type, h.space.address2, h) " +
                    "FROM SpaceOpeningHour h " +
                    "WHERE h.openingTime >= ?1 "
    )
    List<SpaceWithTime> findByOpeningTimeGreaterThanEqual(LocalTime openTime);

    @Transactional
    @Modifying
    @Query(
            "UPDATE SpaceOpeningHour h" +
                    " SET h.openingTime = ?2 , h.closeTime = ?3 " +
                    "WHERE h.timeId = ?1"
    )
    void updateOpenTime(Long timeId, LocalTime openTime, LocalTime closeTime);
}
