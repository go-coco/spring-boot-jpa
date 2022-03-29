package com.see0gan.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.see0gan.space.entity.Location;
import com.see0gan.space.entity.Space;
import com.see0gan.space.repository.AddressRepository;
import com.see0gan.space.service.SearchService;
import com.see0gan.space.service.SpaceServiceImpl;
import com.see0gan.utils.exception.ResourceNotFoundException;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2/spaces")
@RequiredArgsConstructor
public class SearchController {

	private final AddressRepository addressRepository;
	private final SpaceServiceImpl spaceService;
	private final SearchService searchService;
	
	@GetMapping("/location")
	public ResponseEntity<?> findSpaceByCity(
			@RequestParam String city,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "0") int size
//			, @RequestParam(defaultValue = "id, desc") String [] sort)
			
			){
			
				
//		List<Order> orders = new ArrayList<>();
//		
//		if(sort[0].contains(",")){
//			
//			Arrays.asList(sort).forEach( sortOrder -> {
//							String [] _sort = sortOrder.split(",");
//							
			
	//	}
		
		List<Location> spaces = new ArrayList<>();
		Page<Location> pageSpace = addressRepository.findAllByCityContaining(city,  PageRequest.of(page, size));
//		.filter( result -> result.getContent().map(LocationQuery::get))
//		.map(Pageable::get);
//		
		spaces = pageSpace.getContent();
		
		if(spaces.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		Map<String, Object> response = new HashMap<>();
		response.put("result", spaces);
		response.put("currentPage", pageSpace.getNumber());
		response.put("totalItems", pageSpace.getTotalElements());
		response.put("totalPages", pageSpace.getTotalPages());
		
		return new ResponseEntity<> (response, HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> findSpaceOrderByPrice(){
		return null;
		
	}
	
	public ResponseEntity<?> findSpaceOrderByPriceASC(){
		return null;
		
	}
	
	public ResponseEntity<?> findSpaceContainingTags(){
		return null;
		
	}
	
	public ResponseEntity<?> findSpaceByOpenTimeBetween(){
		return null;
		
	}
	
	@GetMapping
	public ResponseEntity<List<Space>> find(@RequestParam(required = false) String type) {

		List<Space> spaces = new ArrayList<>();

		if (type == null) ;
		//	spaces.addAll(spaceService.getSpaces());
		else ;
		//	spaces.addAll(spaceService.findSpaceByType(type));

		if (spaces.isEmpty()) {
			String msg = (type == null ? "" : "with type " + type);
			throw new ResourceNotFoundException("no space found" + msg);
		}

		return ResponseEntity.ok(spaces);
	}
	
	
	@Data
	public class LocationQuery{
		private Location location;
	}
	
}
