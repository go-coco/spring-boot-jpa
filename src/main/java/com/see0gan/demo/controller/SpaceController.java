package com.see0gan.demo.controller;

import com.see0gan.demo.entity.Space;
import com.see0gan.demo.exception.ResourceNotFoundException;
import com.see0gan.demo.service.SpaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping(path = "api/v2/spaces")
public class SpaceController{

    private final SpaceService spaceService;

    @GetMapping
    public ResponseEntity<List<Space>> find(@RequestParam(required = false) String type) {

        List<Space> spaces = new ArrayList<>();

        if(type==null)
            spaces.addAll(spaceService.getSpaces());
        else
            spaces.addAll(spaceService.findSpaceByType(type));

        if (spaces.isEmpty()) {
            String msg = (type==null ? "" : "with type " + type);
            throw new ResourceNotFoundException("no space found" +msg);
        }

        return ResponseEntity.ok(spaces);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Space space) {

        String savedName = spaceService.addNewSpace(space);

        URI location = URI.create(String.format("/api/v2/spaces/%s", space.getSpaceId()));

        return ResponseEntity.created(location).build();
    }


}
