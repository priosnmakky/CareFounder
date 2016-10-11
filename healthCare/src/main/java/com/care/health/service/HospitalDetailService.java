package com.care.health.service;

import java.util.List;

import com.care.health.model.Employee;
import com.care.health.model.HospitalDetail;

public interface HospitalDetailService {
	public HospitalDetail createHospitalDetail(HospitalDetail hospitalDetail);
    public HospitalDetail updateHospitalDetail(HospitalDetail hospitalDetail);
    public void removeHospitalDetail(HospitalDetail hospitalDetail);
    public List<HospitalDetail> getAllHospitalDetail();
    public HospitalDetail getHospitalDetailById(String id);
    
}
