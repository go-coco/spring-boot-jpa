package com.see0gan.utils.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.see0gan.space.dto.SpaceDto;
import com.see0gan.space.dto.SpaceForm;
import com.see0gan.space.entity.Space;


public class SpaceConverter extends Converter<SpaceDto, Space>{

	public SpaceConverter(Function<SpaceDto, Space> fromDto, Function<Space, SpaceDto> fromEntity) {
		super(SpaceConverter::convertToEntity, SpaceConverter::convertToDto);
	}
	
	private static SpaceDto convertToDto(Space space) {
		return new SpaceForm();
	}
	
	private static Space convertToEntity(SpaceDto spaceDto) {
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
