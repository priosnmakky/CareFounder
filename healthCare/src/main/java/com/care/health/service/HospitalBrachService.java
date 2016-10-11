package com.care.health.service;

import java.util.List;

import com.care.health.model.Hospital;
import com.care.health.model.HospitalBrach;
import com.care.health.model.HospitalDetail;

public interface HospitalBrachService {
	public HospitalBrach createHospitalBrach(HospitalBrach hospitalBrach);
    public HospitalBrach updateHospitalBrach(HospitalBrach hospitalBrach);
    public HospitalBrach removeHospitalBrach(HospitalBrach hospitalBrach);
    public List<HospitalBrach> getAllHospitalBrach();
    public HospitalBrach getHospitalBrachById(String id);

    
}
