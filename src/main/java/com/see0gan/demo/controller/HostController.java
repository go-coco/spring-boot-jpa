package com.see0gan.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.see0gan.space.entity.Space;
import com.see0gan.space.service.SpaceServiceImpl;
import com.see0gan.user.auth.ApplicationUser;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "api/v2/hosts")
@RequiredArgsConstructor
public class HostController {

	private final SpaceServiceImpl spaceService;
	
	@GetMapping(path = "/spaces")
	public ResponseEntity<List<Space>> find(@AuthenticationPrincipal ApplicationUser currentUser) {

		List<Space> spaces = new ArrayList<>();

		spaces = spaceService.getSpacesByHostId(2L);
	
		return ResponseEntity.ok(spaces);
	}
}
