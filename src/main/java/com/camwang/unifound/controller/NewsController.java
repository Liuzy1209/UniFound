package com.camwang.unifound.controller;

import com.camwang.unifound.entity.News;
import com.camwang.unifound.repository.NewsRepository;
import com.camwang.unifound.util.UnifoundUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    NewsRepository newsRepository;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public Page<News> getNews(
            @RequestParam(value = "page", required = false, defaultValue = "1") String pageString,
            @RequestParam(value = "count", required = false, defaultValue = "10") String countString
    ) {
        return newsRepository.findAllBy(UnifoundUtil.pageableFactory(pageString, countString));
    }
}
