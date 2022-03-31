package com.see0gan.space.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.see0gan.space.dto.SpaceForm;
import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Location;
import com.see0gan.space.entity.Space;
import com.see0gan.space.repository.HostRepository;
import com.see0gan.space.repository.SpaceRepository;
import com.see0gan.utils.exception.InvalidTypeException;
import com.see0gan.utils.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service("SpaceService")
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService{


    private final SpaceRepository spaceRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
	// TODO : enable to use converter
    // private final SpaceConverter converter;  
    
    
    // TODO use dto
    public List<Space> getSpacesByHostId(Long hostId) {

        return spaceRepository.findAllByHostId(hostId);

    }


    @Override
    public Space getSpaceById(Long spaceId) {
        
    	return spaceRepository.findById(spaceId)
    			.orElseThrow(() -> new ResourceNotFoundException("no space found with id"+spaceId));   	
    }
    
    @Transactional
    @Override
    public void deleteSpaceById(Long spaceId) {

    	// TODO delete flag to be true
        spaceRepository.findById(spaceId)
        				.ifPresentOrElse( space -> spaceRepository.deleteById(spaceId),
        									() -> new ResourceNotFoundException("no space with id"+spaceId));        
    }
    
	@Override
	public Page<Space> getSpaces(Pageable pageable) {
		return spaceRepository.findAll(pageable);
	}

	
	// TODO  : dto validation
    @Transactional
    @Override
    public void saveSpace(SpaceForm spaceInfo) {   	
    	
    	// em? or repository?
    	
    	Host found = entityManager.find(Host.class, spaceInfo.getHost().getHostId());
    	
    	if(found==null) new ResourceNotFoundException("invalid host id");
    	
    	Space space = fromDto(spaceInfo);
    	space.setHost(found);
    	space.setRegDate(LocalDate.now());
    	entityManager.persist(space);
    	
    	Location address = spaceInfo.getAddress();
    	address.setSpace(space);
    	entityManager.persist(address);
    	
     	entityManager.flush();
    	
    }
    
    
    // TODO : dto validation if null, set default value
    @Transactional
    @Override
    public void modifySpaceById(SpaceForm spaceDto) {

        spaceRepository.findById(spaceDto.getSpaceId())
                .ifPresentOrElse( found -> spaceRepository.save(fromDto(spaceDto)),
                		()-> new NoSuchElementException("no space found with id" + spaceDto.getSpaceId()));
    }
    
    
    private static Space fromDto(SpaceForm spaceDto) {
    	return Space.builder()
		.spaceName(spaceDto.getSpaceName())
		.type(spaceDto.getType())
		.price(spaceDto.getPrice())
		.capacity(spaceDto.getCapacity())
		.img1(spaceDto.getImg1())
		.img2(spaceDto.getImg2())
		.intro1(spaceDto.getIntro1())
		.intro2(spaceDto.getIntro2())
		.refund(spaceDto.getRefund())
		//facility
		.hasAirConditioner(spaceDto.hasAirConditioner())
		.hasFreeWifi(spaceDto.hasFreeWifi())
		.hasParkingLot(spaceDto.hasParkingLot())
		.hasPrinter(spaceDto.hasPrinter())
		//tags
		.tag1(spaceDto.getTag1())
		.tag2(spaceDto.getTag2())
		.tag3(spaceDto.getTag3())
		// open time
		.openTime(spaceDto.getOpenTime())
		.closeTime(spaceDto.getCloseTime())
		.holiday(spaceDto.getHoliday())		
		.build();
    }




}
