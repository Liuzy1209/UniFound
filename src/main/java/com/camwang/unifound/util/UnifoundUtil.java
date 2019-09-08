package com.camwang.unifound.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class UnifoundUtil {
    public static Pageable pageableFactory(String pageString, String countString) {
        int page = 1;
        int count = 10;
        try {
            page = Integer.parseInt(pageString);
            count = Integer.parseInt(countString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("页码格式错误");
        }
        return PageRequest.of(page, count);
    }

    public static GeoJsonPoint geoFactory(String geox, String geoy) {
        GeoJsonPoint geoJsonPoint = null;
        try {
            geoJsonPoint = new GeoJsonPoint(Double.parseDouble(geox), Double.parseDouble(geoy));
        } catch (Exception e) {
            throw new RuntimeException("地理位置信息转换错误");
        }
        return geoJsonPoint;
    }

    public static Long longFactory(String string) {
        Long number = null;
        try {
            number = Long.parseLong(string);
        } catch (Exception e) {
            throw new RuntimeException("电话号码或QQ号码信息转换错误");
        }
        return number;
    }
}
