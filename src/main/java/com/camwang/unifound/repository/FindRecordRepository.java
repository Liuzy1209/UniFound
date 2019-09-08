package com.camwang.unifound.repository;

import com.camwang.unifound.entity.FindRecord;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FindRecordRepository extends MongoRepository<FindRecord, ObjectId> {
    Page<FindRecord> findAllBy(Pageable pageable);
}
