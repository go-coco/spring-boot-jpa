package com.see0gan.demo.controller;


import com.see0gan.demo.dto.SpaceWithTag;
import com.see0gan.demo.entity.SpaceCustomTag;
import com.see0gan.demo.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/spaces/tags")
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<SpaceCustomTag> findAllTags(){

        return tagService.findAll();

    }


    @GetMapping(path="{tag_id}")
    public SpaceCustomTag findAllByTagId(@PathVariable String tag_id){

        return tagService.findAllByTagId(Long.parseLong(tag_id));

    }

    @GetMapping(path = "/search")
    public List<SpaceWithTag> findAllByKeyword(@RequestParam("keyword") String keyword){

        return tagService.findAllByKeyword(keyword);

    }


    @PutMapping(path="{tag_id}")
    public int updateTagById(@PathVariable String tag_id,
                                        @RequestBody SpaceCustomTag newTag){

      return tagService.updateTagById(tag_id, newTag);
    }

    @DeleteMapping(path="{tag_id}")
    public void deleteTagById(@PathVariable String tag_id){

        tagService.deleteTagById(tag_id);

    }

}
