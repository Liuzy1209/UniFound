package com.camwang.unifound.controller;

import com.camwang.unifound.entity.Tag;
import com.camwang.unifound.repository.TagRepository;
import com.camwang.unifound.util.UnifoundUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {

    @Autowired
    TagRepository tagRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public Tag getTag(
            @PathVariable("id") String idString
    ) {
        Long id = UnifoundUtil.longFactory(idString);
        return tagRepository.findFirstByIndex(id);
    }

    @RequestMapping(value = "/index/{id}", method = RequestMethod.POST)
    public ResponseEntity postTag(
            @RequestParam(value = "info") String info,
            @RequestParam(value = "color") String color
    ) {
        long count = tagRepository.count();
        Tag tag = new Tag(count, info, color);
        mongoTemplate.save(tag, "tag");
        return new ResponseEntity(HttpStatus.OK);
    }
}
