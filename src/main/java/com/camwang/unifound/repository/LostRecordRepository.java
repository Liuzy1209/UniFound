package com.camwang.unifound.repository;

import com.camwang.unifound.entity.LostRecord;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LostRecordRepository extends MongoRepository<LostRecord, ObjectId> {
    Page<LostRecord> findAllBy(Pageable pageable);
}
