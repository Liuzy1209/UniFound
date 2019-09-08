package com.camwang.unifound.controller;

import com.camwang.unifound.entity.FindRecord;
import com.camwang.unifound.entity.LostRecord;
import com.camwang.unifound.entity.Record;
import com.camwang.unifound.repository.FindRecordRepository;
import com.camwang.unifound.repository.LostRecordRepository;
import com.camwang.unifound.service.RecordService;
import com.camwang.unifound.util.UnifoundUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
public class RecordController {

    @Autowired
    private FindRecordRepository findRecordRepository;
    @Autowired
    private LostRecordRepository lostRecordRepository;
    @Autowired
    private RecordService recordService;

    // 分页查询捡到物品的记录
    @RequestMapping(value = "/findrecord", method = RequestMethod.GET)
    public Page<FindRecord> getFindRecordList(
            @RequestParam(value = "page", required = false, defaultValue = "1") String pageString,
            @RequestParam(value = "count", required = false, defaultValue = "10") String countString
    ) {
        return findRecordRepository.findAllBy(UnifoundUtil.pageableFactory(pageString, countString));
    }

    // 分页查询丢失物品的记录
    @RequestMapping(value =  "/lostrecord", method = RequestMethod.GET)
    public Page<LostRecord> getLostRecordList(
            @RequestParam(value = "page", required = false, defaultValue = "1") String pageString,
            @RequestParam(value = "count", required = false, defaultValue = "10") String countString
    ) {
        return lostRecordRepository.findAllBy(UnifoundUtil.pageableFactory(pageString, countString));
    }

    // 新建一个捡到物品的记录
    @RequestMapping(value = "/findrecord", method = RequestMethod.POST)
    public ResponseEntity postFindRecord(
            @RequestParam(value = "image", required = false) MultipartFile[] images,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "look", required = false) String look,
            @RequestParam(value = "number", required = false) String number,
            @RequestParam(value = "date", required = false) Date date,
            @RequestParam(value = "school", required = false) String school,
            @RequestParam(value = "phone", required = false, defaultValue = "1") String phoneString,
            @RequestParam(value = "wechat", required = false) String wechat,
            @RequestParam(value = "qq", required = false, defaultValue = "1") String qqString,
            @RequestParam(value = "geox", required = false, defaultValue = "1") String geox,
            @RequestParam(value = "geoy", required = false, defaultValue = "1") String geoy
    ){
        long count = findRecordRepository.count();
        FindRecord findRecord = new FindRecord(count, type, look, number, date, school, UnifoundUtil.longFactory(phoneString), wechat, UnifoundUtil.longFactory(qqString), UnifoundUtil.geoFactory(geox, geoy));
        if(recordService.saveRecord(findRecord, images)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    // 新建一个丢失物品的记录
    @RequestMapping(value = "/lostrecord", method = RequestMethod.POST)
    public ResponseEntity postLostRecord(
            @RequestParam(value = "image", required = false) MultipartFile[] images,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "look", required = false) String look,
            @RequestParam(value = "number", required = false) String number,
            @RequestParam(value = "date", required = false) Date date,
            @RequestParam(value = "school", required = false) String school,
            @RequestParam(value = "phone", required = false, defaultValue = "1") String phoneString,
            @RequestParam(value = "wechat", required = false) String wechat,
            @RequestParam(value = "qq", required = false, defaultValue = "1") String qqString,
            @RequestParam(value = "geox", required = false, defaultValue = "1") String geox,
            @RequestParam(value = "geoy", required = false, defaultValue = "1") String geoy
    ){
        long count = lostRecordRepository.count();
        LostRecord lostRecord = new LostRecord(count, type, look, number, date, school, UnifoundUtil.longFactory(phoneString), wechat, UnifoundUtil.longFactory(qqString), UnifoundUtil.geoFactory(geox, geoy));
        if(recordService.saveRecord(lostRecord, images)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }
}
