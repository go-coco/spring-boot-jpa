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
	
    //    @Override
//  public List<SpaceDto> getSpaceDto() {
//
//      return spaceRepository.findAll()
//              .stream()
//              .map(this::convertEntityToDto)
//              .collect(Collectors.toList());
//
//  }
	

//  @Query(
//          "SELECT new com.see0gan.space.dto.SpaceAd(s.spaceId, s.spaceName, s.capacity, s.address, s.price, s.tag)"
//          +"FROM Space s"
//  )
//  List<SpaceAd> findAllForAds();
//  
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

	@Override
	public Page<Space> findSpacesByType(String type, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Space> findAByOrderByPriceAsc(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Space> findByOrderByPriceDesc(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Page<Space> findSpacesByType(String type, Pageable pageable) {
//		
//		 boolean isValidType = type.equals("CONFERENCE") || type.equals("PARTY") || type.equals("PRACTICE") || type.equals("STUDIO");
//
//	     if(!isValidType) throw new InvalidTypeException("Invalid space type");
//
//	     Page<Space> list = spaceRepository.findBySpaceTypeContaining(SpaceType.valueOf(type), pageable);
//return null;
//	     return list;
//	}
}
