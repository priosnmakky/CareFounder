package com.care.health.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Examination")
public class Examination {
	@Id
	private String id;
	String sciName;
    List<String> examinationId;
	List<ExaminationDetail> examinationDetails;
	BigDecimal price;
	Integer level;
	boolean isCheck;
	String createPerson;
	Date createDate;
	String updatePerson;
	Date updateDate;
	Integer status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSciName() {
		return sciName;
	}
	public void setSciName(String sciName) {
		this.sciName = sciName;
	}

	public List<String> getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(List<String> examinationId) {
		this.examinationId = examinationId;
	}
	public List<ExaminationDetail> getExaminationDetails() {
		return examinationDetails;
	}
	public void setExaminationDetails(List<ExaminationDetail> examinationDetails) {
		this.examinationDetails = examinationDetails;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdatePerson() {
		return updatePerson;
	}
	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}	
}
