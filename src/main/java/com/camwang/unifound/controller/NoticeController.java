package com.camwang.unifound.controller;

import com.camwang.unifound.entity.Notice;
import com.camwang.unifound.repository.NoticeRepository;
import com.camwang.unifound.util.UnifoundUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @Autowired
    NoticeRepository noticeRepository;

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public Page<Notice> getNotice(
            @RequestParam(value = "page", required = false, defaultValue = "1") String pageString,
            @RequestParam(value = "count", required = false, defaultValue = "10") String countString
    ) {
        return noticeRepository.findAllBy(UnifoundUtil.pageableFactory(pageString, countString));
    }
}
