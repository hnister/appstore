package com.grizzly.model;

import java.io.Serializable;
import java.util.Date;

public class AppInform implements Serializable {
	private long id;
	private String softwareName;
	private String APKName;
	private String supportROM;
	private String interfaceLanguage;
	private double softwareSize;
	private Date updateDate;
	private long devId;
	private String appInfo;
	private long status;
	private Date onSaleDate;
	private Date offSaleDate;
	private long flatformId;
	private long categoryLevel3;
	private long downloads;
	private long createdBy;
	private Date creationDate;
	private long modifyBy;
	private Date modifyDate;
	private long categoryLevel1;
	private long categoryLevel2;
	private String logoPicPath;
	private String logoLocPath;
	private long versionId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public String getSupportROM() {
		return supportROM;
	}
	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(double softwareSize) {
		this.softwareSize = softwareSize;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public long getDevId() {
		return devId;
	}
	public void setDevId(long devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public long getFlatformId() {
		return flatformId;
	}
	public void setFlatformId(long flatformId) {
		this.flatformId = flatformId;
	}
	public long getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(long categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public long getDownloads() {
		return downloads;
	}
	public void setDownloads(long downloads) {
		this.downloads = downloads;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public long getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(long categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public long getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(long categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public long getVersionId() {
		return versionId;
	}
	public void setVersionId(long versionId) {
		this.versionId = versionId;
	}
	@Override
	public String toString() {
		return "AppInform [id=" + id + ", softwareName=" + softwareName + ", APKName=" + APKName + ", supportROM="
				+ supportROM + ", interfaceLanguage=" + interfaceLanguage + ", softwareSize=" + softwareSize
				+ ", updateDate=" + updateDate + ", devId=" + devId + ", appInfo=" + appInfo + ", status=" + status
				+ ", onSaleDate=" + onSaleDate + ", offSaleDate=" + offSaleDate + ", flatformId=" + flatformId
				+ ", categoryLevel3=" + categoryLevel3 + ", downloads=" + downloads + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate
				+ ", categoryLevel1=" + categoryLevel1 + ", categoryLevel2=" + categoryLevel2 + ", logoPicPath="
				+ logoPicPath + ", logoLocPath=" + logoLocPath + ", versionId=" + versionId + "]";
	}
	
}
