//package com.see0gan.space.repository;
//
//import java.time.LocalTime;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.see0gan.space.entity.SpaceOpenTime;
//
//public interface OpenTimeRepository extends JpaRepository<SpaceOpenTime, Long> {
//
////    @Query(
////            "SELECT new com.see0gan.space.dto.SpaceWithTime(h.space.spaceId, h.space.spaceName, h.space.type, h.space.address, h) " +
////                    "FROM SpaceOpeningHour h " +
////                    "WHERE h.openingTime >= ?1 "
////    )
////    List<SpaceWithTime> findByOpeningTimeGreaterThanEqual(LocalTime openTime);
//
//	
//	@Query(
//			"SELECT o "
//			+ "FROM SpaceOpenTime o "
//			+ "WHERE o.openTime >= :startTime AND o.closeTime < :endTime"
//			)	
//	Page<SpaceOpenTime> findAllBetween(
//			@Param("startTime") LocalTime startTime,
//			@Param("startTime") LocalTime endTime,
//			Pageable pageable	);
//	
//	
//    @Transactional    
//    @Modifying
//    @Query(
//            "UPDATE SpaceOpenTime h" +
//                    " SET h.openTime = ?2 , h.closeTime = ?3 " +
//                    "WHERE h.openingId = ?1"
//    )
//    void updateOpenTime(Long timeId, LocalTime openTime, LocalTime closeTime);
//    
//    
//    @Query(
//            "SELECT h"
//            +" FROM SpaceOpenTime h" +
//             " WHERE h.space.spaceId = ?1"
//    )
//    Optional<SpaceOpenTime> findBySpaceId(Long spaceId);
//    
//
//    List<SpaceOpenTime> findByHolidayNotIn(List<String> Days);
//    
//    
//}
