package com.see0gan.space.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.see0gan.space.entity.Space;
import com.see0gan.space.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

	private final AddressRepository addressReposiotry;
	
	@Override
	public Page<Space> getAvailableSpacesByDate(LocalDate date, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Space> getSpacesByTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Space> getSpacesByFacilitiesHaving() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Space> getSpacesByLocation(String city, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	//	return addressReposiotry.findAllByCityContaining(city, null);
	}

}
