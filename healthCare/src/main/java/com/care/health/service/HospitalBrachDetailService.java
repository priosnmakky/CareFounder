package com.care.health.service;

import java.util.List;

import com.care.health.model.HospitalBrachDetail;
import com.care.health.model.HospitalDetail;

public interface HospitalBrachDetailService  {
	public HospitalBrachDetail createHospitalBrachDetail(HospitalBrachDetail hospitalBrachDetail);
    public HospitalBrachDetail updateHospitalBrachDetail(HospitalBrachDetail hospitalBrachDetail);
    public void removeHospitalBrachDetail(HospitalBrachDetail hospitalBrachDetail);
    public List<HospitalBrachDetail> getAllHospitalBrachDetail();
    public HospitalBrachDetail getHospitalBrachDetailById(String id);
    
}
