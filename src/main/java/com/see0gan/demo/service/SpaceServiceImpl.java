package com.see0gan.demo.service;

import com.see0gan.demo.dto.SpaceAd;
import com.see0gan.demo.dto.SpaceDto;
import com.see0gan.demo.entity.Space;
import com.see0gan.demo.entity.SpaceType;
import com.see0gan.demo.exception.InvalidTypeException;
import com.see0gan.demo.exception.ResourceNotFoundException;
import com.see0gan.demo.repository.HostRepository;
import com.see0gan.demo.repository.SpaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpaceServiceImpl implements SpaceService{

    private final SpaceRepository spaceRepository;
    private final HostRepository hostRepository;

    public SpaceServiceImpl(SpaceRepository spaceRepository, HostRepository hostRepository) {
        this.spaceRepository = spaceRepository;
        this.hostRepository = hostRepository;
    }


    public List<Space> findSpaceByType(String type){

        boolean isValidType = type.equals("CONFERENCE") || type.equals("PARTY") || type.equals("PRACTICE") || type.equals("STUDIO");

        if(!isValidType) throw new InvalidTypeException("Invalid space type");

        List<Space> list = spaceRepository.findByType(SpaceType.valueOf(type));

        return list;

    }


    @Override
    public List<SpaceDto> getSpaceDto() {

        return spaceRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<Space> getSpaces() {

        return spaceRepository.findAll();

    }


    @Override
    public Space getSpaceById(Long spaceId) {
        Optional<Space> space = spaceRepository.findById(spaceId);

        return space.orElseThrow(() -> new ResourceNotFoundException("no space with id"));
    }

    @Transactional
    @Override
    public String addNewSpace(Space space) {

        if(hostRepository.getHostByEmail(space.getHost().getEmail()).isPresent())
            throw new InvalidTypeException("host email already taken");

        spaceRepository.save(space);

        return space.getSpaceName();
    }

    @Override
    public void deleteSpaceById(Long spaceId) {

        Optional<Space> found = spaceRepository.findById(spaceId);

        if(found.isEmpty())
            throw new ResourceNotFoundException("no space with id");

        spaceRepository.deleteById(spaceId);
    }

    @Transactional
    @Override
    public void modifySpaceById(Long spaceId, Space space) {

        Space found = spaceRepository.findById(spaceId)
                .orElseThrow(()-> new NoSuchElementException("no space with id"));


        spaceRepository.save(space);

    }

    @Override
    public List<SpaceAd> getSpaceAds() {
        return spaceRepository.findAllForAds();

    }

    private SpaceDto convertEntityToDto(Space space) {

        SpaceDto spaceDto = new SpaceDto();

        spaceDto.setSpaceName(space.getSpaceName());
        spaceDto.setType(space.getType());
        spaceDto.setCapacity(space.getCapacity());
        spaceDto.setImg1(space.getImg1());
        spaceDto.setImg2(space.getImg2());
        spaceDto.setAddress2(space.getAddress2());
        spaceDto.setTags(space.getTag());

        return spaceDto;
    }

    private Space convertDtoToEntity(SpaceDto spaceDto){

        return Space.builder()
                .spaceName(spaceDto.getSpaceName())
                .type(spaceDto.getType())
                .capacity(spaceDto.getCapacity())
                .img1(spaceDto.getImg1())
                .img2(spaceDto.getImg2())
                .address2(spaceDto.getAddress2())
                .tag(spaceDto.getTags())
                .build();

    }
}
