package com.see0gan.space.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.see0gan.space.dto.SpaceWithTag;
import com.see0gan.space.entity.SpaceCustomTag;

public interface SpaceCustomTagRepository extends JpaRepository<SpaceCustomTag, Long> {

    Optional<SpaceCustomTag> findByTagId(Long tagId);


    @Transactional
    @Modifying
    @Query("UPDATE SpaceCustomTag t " +
            " SET t.tag1 = ?2 " +
            ", t.tag2 = ?3" +
            ", t.tag3 = ?4" +
            " WHERE t.tagId = ?1")
    int updateTagById(Long tag_id,
                          String tag1,
                          String tag2,
                          String tag3);


    @Query(
            "SELECT new com.see0gan.space.dto.SpaceWithTag(s.spaceId, s.spaceName, s.price, s.address, s.tag)" +
                    " FROM SpaceCustomTag t, Space s " +
                    " WHERE t.tag1 like %?1% or t.tag2 like %?1% or t.tag3 like %?1%"
    )
   List<SpaceWithTag> findAllByKeyword(String keyword);
    
    
}
