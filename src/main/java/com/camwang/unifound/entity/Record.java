package com.camwang.unifound.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Date;

public interface Record {
    ObjectId getObjectId();

    void setObjectId(ObjectId objectId);

    Long getIndex();

    void setIndex(Long index);

    String[] getImage();

    void setImage(String[] image);

    String getType();

    void setType(String type);

    String getLook();

    void setLook(String look);

    String getNumber();

    void setNumber(String number);

    Date getDate();

    void setDate(Date date);

    String getSchool();

    void setSchool(String school);

    Long getPhone();

    void setPhone(Long phone);

    String getWechat();

    void setWechat(String wechat);

    Long getQq();

    void setQq(Long qq);

    GeoJsonPoint getGeoJsonPoint();

    void setGeoJsonPoint(GeoJsonPoint geoJsonPoint);
}
