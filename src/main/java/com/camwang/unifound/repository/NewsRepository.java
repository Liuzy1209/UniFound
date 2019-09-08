package com.camwang.unifound.repository;

import com.camwang.unifound.entity.News;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, ObjectId> {
    Page<News> findAllBy(Pageable pageable);
}
