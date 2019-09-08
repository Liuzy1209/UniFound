package com.camwang.unifound.service;

import com.camwang.unifound.entity.Record;
import com.camwang.unifound.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class RecordService {

    @Autowired
    MongoTemplate mongoTemplate;

    public boolean saveRecord(Record record, MultipartFile[] images) {
        String[] s = new String[3];
        int index = 0;
        if (images != null) {
            for(MultipartFile image : images) {
                if(image != null) {
                    String originalFileName = image.getOriginalFilename();
                    String suffix;
                    if (originalFileName != null) {
                        suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
                    } else {
                        continue;
                    }
                    String fileName = UUID.randomUUID().toString() + suffix;
                    String filePath = Constants.IMG_PATH + fileName;
                    File saveFile = new File(filePath);
                    try {
                        image.transferTo(saveFile);
                        s[index] = fileName;
                    } catch (IOException ignored) { }
                }
            }
        }
        record.setImage(s);
        if(record.getClass().getName().equals("com.camwang.unifound.entity.LostRecord")) {
            mongoTemplate.save(record, "lostrecord");
        } else {
            mongoTemplate.save(record, "findrecord");
        }
        return true;
    }
}
