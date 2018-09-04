package com.example.demo.model;

import java.util.Date;

/**
 * Created by mahongbin on 2018/9/4.
 */
public class App {
    private int id;
    private int appType;
    private String versionNumber;
    private String internalVerNumber;
    private String downloadUrl;
    private int reUpdate;
    private String remark;
    private String qrCodeImage;
    private Date creatTime;
    private Date updateTime;
    private int deleteState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getInternalVerNumber() {
        return internalVerNumber;
    }

    public void setInternalVerNumber(String internalVerNumber) {
        this.internalVerNumber = internalVerNumber;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public int getReUpdate() {
        return reUpdate;
    }

    public void setReUpdate(int reUpdate) {
        this.reUpdate = reUpdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(int deleteState) {
        this.deleteState = deleteState;
    }
}
