package com.camwang.unifound.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "user")
public class User {
    @Id private ObjectId objectId;
    @Indexed(direction = IndexDirection.DESCENDING) private Long index;
    private String username;
    private String password;
    private String nick;
    private String avatar;
    private String school;
    private String wechat;
    private Long phone;
    private Long qq;
    private Integer points;
    @Field("regdate") private Date regDate;
    @DBRef private List<LostRecord> lostRecordList;
    @DBRef private List<FindRecord> findRecordList;

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public List<LostRecord> getLostRecordList() {
        return lostRecordList;
    }

    public void setLostRecordList(List<LostRecord> lostRecordList) {
        this.lostRecordList = lostRecordList;
    }

    public List<FindRecord> getFindRecordList() {
        return findRecordList;
    }

    public void setFindRecordList(List<FindRecord> findRecordList) {
        this.findRecordList = findRecordList;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public User() { }

    @PersistenceConstructor
    public User(Long index, String username, String password, String nick, String avatar, String school, String wechat, Long phone, Long qq, Integer points, Date regDate, List<LostRecord> lostRecordList, List<FindRecord> findRecordList) {
        this.index = index;
        this.username = username;
        this.password = password;
        this.nick = nick;
        this.avatar = avatar;
        this.school = school;
        this.wechat = wechat;
        this.phone = phone;
        this.qq = qq;
        this.points = points;
        this.regDate = regDate;
        this.lostRecordList = lostRecordList;
        this.findRecordList = findRecordList;
    }
}
