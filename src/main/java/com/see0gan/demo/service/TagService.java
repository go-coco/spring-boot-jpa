package com.see0gan.demo.service;

import com.see0gan.demo.dto.SpaceWithTag;
import com.see0gan.demo.entity.SpaceCustomTag;
import com.see0gan.demo.exception.ResourceNotFoundException;
import com.see0gan.demo.repository.SpaceCustomTagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TagService {

    private final SpaceCustomTagRepository tagRepository;

    public SpaceCustomTag findAllByTagId(Long tagId) {

        return tagRepository.findByTagId(tagId).orElseThrow(() -> new ResourceNotFoundException("no tag id with " +tagId));
    }


    public int updateTagById(String tag_id, SpaceCustomTag newTag) {

        SpaceCustomTag found = tagRepository.findByTagId(Long.parseLong(tag_id)).orElseThrow(()
                                                            -> new ResourceNotFoundException("no tag id with " +tag_id));


        return tagRepository.updateTagById(Long.parseLong(tag_id),
                (newTag.getTag1() == null ? found.getTag1() : newTag.getTag1()),
                (newTag.getTag2() == null ? found.getTag2() : newTag.getTag2()),
                (newTag.getTag3() == null ? found.getTag3() : newTag.getTag3())

      );

    }


    public List<SpaceCustomTag> findAll() {

        return tagRepository.findAll();
    }

    public void deleteTagById(String tag_id) {

        SpaceCustomTag found = tagRepository.findByTagId(Long.parseLong(tag_id)).orElseThrow(()
                                                            -> new ResourceNotFoundException("no tag id with " +tag_id));

        tagRepository.deleteById(found.getTagId());
    }

    public List<SpaceWithTag> findAllByKeyword(String keyword) {

        return tagRepository.findAllByKeyword(keyword);
    }
}

