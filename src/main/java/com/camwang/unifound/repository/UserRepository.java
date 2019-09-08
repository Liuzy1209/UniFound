package com.camwang.unifound.repository;

import com.camwang.unifound.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findFirstByUsername(String username);
    User findFirstByUsernameAndPassword(String username, String password);
}
