package com.care.health.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ExaminationDetail")
public class ExaminationDetail {
	@Id
	String id;
	String name;
	String detail;
	Integer word;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getWord() {
		return word;
	}
	public void setWord(Integer word) {
		this.word = word;
	}
	
	
}
