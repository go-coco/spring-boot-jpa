package com.see0gan.utils;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.see0gan.space.dto.SpaceForm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SpaceOperation {
	

	private final EntityManager em;
	
	public void saveSpace(SpaceForm spaceInfo) {
		
//		em.
	}
	

}
