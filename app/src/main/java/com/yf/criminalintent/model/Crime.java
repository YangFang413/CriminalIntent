package com.yf.criminalintent.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/23.
 * Crime的实体类
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate; // 时间
    private boolean mSolved; // 解决与否
    private String mSuspect; // 嫌疑人

    public Crime(){
        // 随机生成一个唯一的id
        // mId = UUID.randomUUID();
        // mDate = new Date(); // 将当前时间设置为默认的mDate
        this(UUID.randomUUID());
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String mSuspect) {
        this.mSuspect = mSuspect;
    }

    public String getPhotoFileName(){
        return "IMG_" + getId().toString() + ".jpg";
    }
}
