package com.camwang.unifound.repository;

import com.camwang.unifound.entity.Notice;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeRepository extends MongoRepository<Notice, ObjectId> {
    Page<Notice> findAllBy(Pageable pageable);
}
