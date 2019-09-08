package com.camwang.unifound.controller;

import com.camwang.unifound.entity.Suggestion;
import com.camwang.unifound.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SuggestionController {
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Autowired
    SuggestionRepository suggestionRepository;

    @RequestMapping(value = "/suggestion", method = RequestMethod.POST)
    public ResponseEntity postSuggestion(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "content") String content
    ) {
        Long count = suggestionRepository.count();
        Date date = new Date();
        Suggestion suggestion = new Suggestion(count, content, date, username);
        mongoTemplate.save(suggestion, "suggestion");
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
}
