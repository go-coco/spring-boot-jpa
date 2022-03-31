package com.see0gan.space.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceType;

@Repository
public interface SearchRepository extends JpaRepository<Space, Long>{

	// multiple query required, Period max 3 month earlier?
//	@Query(" TemporaryClosure tc, ... -> CustomSearchRepo"
//			+ "")
//	Page<Space> getAvailableSpacesByDate(LocalDate date, Pageable pageable);
	
	// TODO : when having list of tags, then? -> IN Operator
	 @Query(
           "SELECT s"+//new com.see0gan.space.dto.SpaceWithTag(s.spaceId, s.spaceName, s.price, s.address, s.tag)" +
                   " FROM Space s " +
                   " WHERE s.tag1 like %?1% or s.tag2 like %?1% or s.tag3 like %?1%"
   )
	 Page<Space> getSpacesByTag(String tag, Pageable pageable);
	
	 // list 넘기면 찾아주나? or 조건으로? 조건 하나로 response 보내면 front에서 필터 거르면 됨!
	 // 이건... sort 조건이 필요하겠다
	 @Query(
			 "SELECT s"
	 		+ " FROM Space s"
	 		+ " WHERE s.hasAirConditioner = :hasAirCon"
	 		+ " AND s.hasPrinter = :hasPrinter"
	 		+ "	AND s.hasFreeWifi = :hasWifi"
	 		+ " AND s.hasParkingLot = :hasParking")
	 Page<Space> getSpacesByFacilitiesHaving(
			 @Param("hasAirCon") boolean air,
			 @Param("hasPrinter") boolean printer,
			 @Param("hasParking") boolean parking,
			 @Param("hasWifi") boolean wifi,
			 Pageable pageable);
	
	// join fetch 해서 select
	@Query(
			"SELECT s"
			+ " FROM Space s JOIN FETCH Location l ON s.spaceId = l.space.spaceId"
			+ " WHERE l.city = ?1")
	Page<Space> getSpacesByLocation(String city, Pageable pageable);
	
	// derived query
	Page<Space> findSpacesByType(SpaceType type, Pageable pageable);
	
	Page<Space> findAByOrderByPriceAsc(Pageable pageable);
	   
	Page<Space> findByOrderByPriceDesc(Pageable pageable);
}
