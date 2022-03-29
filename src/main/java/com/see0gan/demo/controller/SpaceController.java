package com.see0gan.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.see0gan.space.dto.SpaceForm;
import com.see0gan.space.entity.Space;
import com.see0gan.space.entity.TemporaryClosure;
import com.see0gan.space.service.SpaceService;
import com.see0gan.space.service.SpaceServiceImpl;
import com.see0gan.user.auth.ApplicationUser;
import com.see0gan.utils.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "SPACE_CONTROLLER")
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "api/v2/spaces")
public class SpaceController {

	private final SpaceServiceImpl spaceService;
	
//	public SpaceController(SpaceServiceImpl service) {
//		this.spaceService = service;
//	}

	@GetMapping(path = "{space_id}")
	public Space getSpace(@PathVariable("space_id") Long spaceId) {

		Space space = spaceService.getSpaceById(spaceId);

		return space;
	}


	@PostMapping(path = "/closure")
	
	public ResponseEntity<?> addTemporaryClosure(@RequestBody TemporaryClosure temporaryClosure) {

		// spaceInfo.setHostId(1L);//currentUser.getUserId());
//		log.info(spaceInfo.getImg1());
//		log.info(spaceInfo.getHost().getEmail());

		// String savedName =
	//	Long closureId = spaceService.addTemporaryClosure(temporaryClosure);

//		URI location = URI.create(String.format("/api/v2/spaces/closure/%s", Long.toString(closureId)));

	//	return ResponseEntity.created(location).build();

		return null;
	}
	

	@PostMapping
	public ResponseEntity<?> createSpace(@RequestBody SpaceForm spaceInfo,
			@AuthenticationPrincipal ApplicationUser currentUser) {

		// spaceInfo.setHostId(1L);//currentUser.getUserId());
		log.info(spaceInfo.getImg1());
		log.info(spaceInfo.getHost().getEmail());

		// String savedName =
		spaceService.saveSpace(spaceInfo);

		URI location = URI.create(String.format("/api/v2/spaces/%s", spaceInfo.getSpaceName()));

		return ResponseEntity.created(location).build();

	}

}
