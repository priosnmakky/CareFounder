package com.care.health.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Image")
public class Image {
	@Id
    private String id;
	String type;
	String byteOrpart;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getByteOrpart() {
		return byteOrpart;
	}
	public void setByteOrpart(String byteOrpart) {
		this.byteOrpart = byteOrpart;
	}


	
	
}
