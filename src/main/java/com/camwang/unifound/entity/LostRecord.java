package com.camwang.unifound.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "lostrecord")
public class LostRecord implements Record{
    @Id private ObjectId objectId;
    @Indexed(direction = IndexDirection.DESCENDING) private Long index;
    private String[] image;
    @TextIndexed private String type;
    @TextIndexed private String look;
    private String number;
    private Date date;
    private String school;
    private Long phone;
    private String wechat;
    private Long qq;
    private GeoJsonPoint geoJsonPoint;

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public GeoJsonPoint getGeoJsonPoint() {
        return geoJsonPoint;
    }

    public void setGeoJsonPoint(GeoJsonPoint geoJsonPoint) {
        this.geoJsonPoint = geoJsonPoint;
    }

    public LostRecord() { }

    public LostRecord(Long index, String type, String look, String number, Date date, String school, Long phone, String wechat, Long qq, GeoJsonPoint geoJsonPoint) {
        this.index = index;
        this.type = type;
        this.look = look;
        this.number = number;
        this.date = date;
        this.school = school;
        this.phone = phone;
        this.wechat = wechat;
        this.qq = qq;
        this.geoJsonPoint = geoJsonPoint;
    }

    @PersistenceConstructor
    public LostRecord(Long index, String[] image, String type, String look, String number, Date date, String school, Long phone, String wechat, Long qq, GeoJsonPoint geoJsonPoint) {
        this.index = index;
        this.image = image;
        this.type = type;
        this.look = look;
        this.number = number;
        this.date = date;
        this.school = school;
        this.phone = phone;
        this.wechat = wechat;
        this.qq = qq;
        this.geoJsonPoint = geoJsonPoint;
    }
}
