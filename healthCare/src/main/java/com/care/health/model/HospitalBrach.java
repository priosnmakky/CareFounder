package com.care.health.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="HospitalBrach")
public class HospitalBrach {
	@Id
	String id;
	String tel;
	String fax;
	String facebook;
	String twitter;
	List<Address> address;
	List<HospitalBrachDetail> hospitalBrachDetails;
	List<Examination> examinations;
	String  usernameHos;
	Date createDate;
	Date updateDate;
	Integer status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	

	public List<Examination> getExaminations() {
		return examinations;
	}
	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}
	public String getUsernameHos() {
		return usernameHos;
	}
	public void setUsernameHos(String usernameHos) {
		this.usernameHos = usernameHos;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public List<HospitalBrachDetail> getHospitalBrachDetails() {
		return hospitalBrachDetails;
	}
	public void setHospitalBrachDetails(List<HospitalBrachDetail> hospitalBrachDetails) {
		this.hospitalBrachDetails = hospitalBrachDetails;
	}
	
	
	

}
