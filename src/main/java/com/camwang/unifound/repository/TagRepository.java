package com.camwang.unifound.repository;

import com.camwang.unifound.entity.Tag;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, ObjectId> {
    Tag findFirstByIndex(Long index);
}
