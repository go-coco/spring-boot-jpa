package com.see0gan.space.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.see0gan.space.entity.TemporaryClosure;

@Repository
public interface TemporaryClosureRepository extends JpaRepository<TemporaryClosure, Long>{

	List<TemporaryClosure> findByDate(LocalDate date);
	
	
	@Query(
			"SELECT t "
			+ "FROM TemporaryClosure t "
			+ "WHERE t.space.spaceId = ?1")
	List<TemporaryClosure> findBySpaceId(Long spaceId);

	
}
