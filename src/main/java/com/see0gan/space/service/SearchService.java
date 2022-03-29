package com.see0gan.space.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.see0gan.space.entity.Space;


public interface SearchService {
	
	int PAGE_MAX_SIZE = 10;
	
	// TODO fetch operation with dto
	
	Page<Space> getAvailableSpacesByDate(LocalDate date, Pageable pageable);
	
	Page<Space> getSpacesByTags();
	
	Page<Space> getSpacesByFacilitiesHaving();
	
	Page<Space> getSpacesByLocation(String city, Pageable pageable);

	
}
