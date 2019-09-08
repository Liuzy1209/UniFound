package com.camwang.unifound.repository;

import com.camwang.unifound.entity.Suggestion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuggestionRepository extends MongoRepository<Suggestion, ObjectId> {
}
