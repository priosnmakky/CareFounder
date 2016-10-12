package com.care.health.model;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.google.api.client.util.DateTime;

public class YoutubeVideo {
	@Id
    private String id;
	String name;
	String title;
	List<String> tag;
	String description;
	String privacyStatus;
	String byteOrpart;
	BigInteger viewCount;
	DateTime publishDate;
	///BigInteger ViewCount;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getTag() {
		return tag;
	}
	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivacyStatus() {
		return privacyStatus;
	}
	public void setPrivacyStatus(String privacyStatus) {
		privacyStatus = privacyStatus;
	}
	public String getByteOrpart() {
		return byteOrpart;
	}
	public void setByteOrpart(String byteOrpart) {
		this.byteOrpart = byteOrpart;
	}
	public DateTime getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(DateTime publishDate) {
		this.publishDate = publishDate;
	}
	public BigInteger getViewCount() {
		return viewCount;
	}
	public void setViewCount(BigInteger viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
	
	
}
