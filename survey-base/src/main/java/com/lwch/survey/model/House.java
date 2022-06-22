package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class House {
    private String id;

    private String buildNo;

    private String lpzh;

    private String houseNo;

    private String buildStructure;

    private Integer layersTotal;

    private Integer layersLocation;

    private Double buildArea;

    private Double innerArea;

    private Double shareArea;

    private Double ytmj;

    private String roomId;

    private String ownerFlat;

    private String ownerRoom;

    private String planUse;

    private Date updateTime;

    private String funcName;

    private String myc;

    private String zrzzc;

    private Double ftxs;
    
    private List<House> children = new ArrayList<>();

    public List<House> getChildren() {
        return children;
    }

    public void setChildren(List<House> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildNo() {
        return buildNo;
    }

    public void setBuildNo(String buildNo) {
        this.buildNo = buildNo;
    }

    public String getLpzh() {
        return lpzh;
    }

    public void setLpzh(String lpzh) {
        this.lpzh = lpzh;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getBuildStructure() {
        return buildStructure;
    }

    public void setBuildStructure(String buildStructure) {
        this.buildStructure = buildStructure;
    }

    public Integer getLayersTotal() {
        return layersTotal;
    }

    public void setLayersTotal(Integer layersTotal) {
        this.layersTotal = layersTotal;
    }

    public Integer getLayersLocation() {
        return layersLocation;
    }

    public void setLayersLocation(Integer layersLocation) {
        this.layersLocation = layersLocation;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public Double getInnerArea() {
        return innerArea;
    }

    public void setInnerArea(Double innerArea) {
        this.innerArea = innerArea;
    }

    public Double getShareArea() {
        return shareArea;
    }

    public void setShareArea(Double shareArea) {
        this.shareArea = shareArea;
    }

    public Double getYtmj() {
        return ytmj;
    }

    public void setYtmj(Double ytmj) {
        this.ytmj = ytmj;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getOwnerFlat() {
        return ownerFlat;
    }

    public void setOwnerFlat(String ownerFlat) {
        this.ownerFlat = ownerFlat;
    }

    public String getOwnerRoom() {
        return ownerRoom;
    }

    public void setOwnerRoom(String ownerRoom) {
        this.ownerRoom = ownerRoom;
    }

    public String getPlanUse() {
        return planUse;
    }

    public void setPlanUse(String planUse) {
        this.planUse = planUse;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getMyc() {
        return myc;
    }

    public void setMyc(String myc) {
        this.myc = myc;
    }

    public String getZrzzc() {
        return zrzzc;
    }

    public void setZrzzc(String zrzzc) {
        this.zrzzc = zrzzc;
    }

    public Double getFtxs() {
        return ftxs;
    }

    public void setFtxs(Double ftxs) {
        this.ftxs = ftxs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buildNo=").append(buildNo);
        sb.append(", lpzh=").append(lpzh);
        sb.append(", houseNo=").append(houseNo);
        sb.append(", buildStructure=").append(buildStructure);
        sb.append(", layersTotal=").append(layersTotal);
        sb.append(", layersLocation=").append(layersLocation);
        sb.append(", buildArea=").append(buildArea);
        sb.append(", innerArea=").append(innerArea);
        sb.append(", shareArea=").append(shareArea);
        sb.append(", ytmj=").append(ytmj);
        sb.append(", roomId=").append(roomId);
        sb.append(", ownerFlat=").append(ownerFlat);
        sb.append(", ownerRoom=").append(ownerRoom);
        sb.append(", planUse=").append(planUse);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", funcName=").append(funcName);
        sb.append(", myc=").append(myc);
        sb.append(", zrzzc=").append(zrzzc);
        sb.append(", ftxs=").append(ftxs);
        sb.append("]");
        return sb.toString();
    }
}