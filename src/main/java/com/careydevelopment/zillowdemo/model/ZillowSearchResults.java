package com.careydevelopment.zillowdemo.model;

public class ZillowSearchResults {
	
	private String zpid;
	private String value;
	private String lowValue;
	private String highValue;
	private String lastUpdated;
	private String mapUrl;
	private String comparablesUrl;
	
	public String getZpid() {
		return zpid;
	}
	public void setZpid(String zpid) {
		this.zpid = zpid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLowValue() {
		return lowValue;
	}
	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}
	public String getHighValue() {
		return highValue;
	}
	public void setHighValue(String highValue) {
		this.highValue = highValue;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getMapUrl() {
		return mapUrl;
	}
	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	public String getComparablesUrl() {
		return comparablesUrl;
	}
	public void setComparablesUrl(String comparablesUrl) {
		this.comparablesUrl = comparablesUrl;
	}
}
