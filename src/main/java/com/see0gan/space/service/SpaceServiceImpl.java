package com.see0gan.space.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.see0gan.space.dto.SpaceDto;
import com.see0gan.space.dto.SpaceForm;
import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Location;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.SpaceCustomTag;
import com.see0gan.space.entity.SpaceFacility;
import com.see0gan.space.entity.SpaceOpenTime;
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

    
    //    @Override
//    public List<SpaceDto> getSpaceDto() {
//
//        return spaceRepository.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//
//    }

    
    
    
    public List<Space> getSpacesByHostId(Long hostId) {

        return spaceRepository.findAllByHostId(hostId);

    }


    @Override
    public Space getSpaceById(Long spaceId) {
        
    	return spaceRepository.findById(spaceId)
    			.orElseThrow(() -> new ResourceNotFoundException("no space with id"));
    	
    }
    
    @Transactional
    @Override
    public void deleteSpaceById(Long spaceId) {

        spaceRepository.findById(spaceId)
        				.ifPresentOrElse( space -> spaceRepository.deleteById(space.getSpaceId()),
        									() -> new ResourceNotFoundException("no space with id"+spaceId));        
    }
    
	@Override
	public Page<Space> findSpacesByType(String type, Pageable pageable) {
		
		 boolean isValidType = type.equals("CONFERENCE") || type.equals("PARTY") || type.equals("PRACTICE") || type.equals("STUDIO");

	     if(!isValidType) throw new InvalidTypeException("Invalid space type");

//	     Page<Space> list = spaceRepository.findBySpaceTypeContaining(SpaceType.valueOf(type), pageable);
return null;
//	     return list;
	}
	
	@Override
	public Page<Space> getSpaces(Pageable pageable) {
		return spaceRepository.findAll(pageable);
	}

	
	// TODO  : dto validation
    @Transactional
    @Override
    public void saveSpace(SpaceForm spaceInfo) {   	
    	
    	
    	Host found = entityManager.find(Host.class, spaceInfo.getHost().getHostId());
    	
    	if(found==null) new ResourceNotFoundException("invalid host id");
    	
    	Space space = fromDto(spaceInfo);
    	space.setHost(found);
    	entityManager.persist(space);
    	
    	Location address = spaceInfo.getAddress();
    	address.setSpaceId(space);
    	entityManager.persist(address);
    	
    	SpaceCustomTag tags = spaceInfo.getTags();
    	tags.setSpaceId(space);
    	entityManager.persist(tags);
    	
    	SpaceOpenTime sot = spaceInfo.getOpenTime();
    	sot.setSpace(space);
    	entityManager.persist(sot);
    	
    	SpaceFacility facility = spaceInfo.getFacility();
    	facility.setSpace(space);    	
    	entityManager.persist(facility);
    	
     	entityManager.flush();
    	
    }
    
    
  
    @Transactional
    @Override
    public void modifySpaceById(SpaceForm spaceDto) {

        spaceRepository.findById(spaceDto.getSpaceId())
                .ifPresentOrElse( found -> spaceRepository.save(fromDto(spaceDto)),
                		()-> new NoSuchElementException("no space with id"));

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
		.build();
    }




}
