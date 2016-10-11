package com.care.health.service;

import java.util.List;


import com.care.health.model.Hospital;

public interface HospitalService {
	public Hospital createHospital(Hospital hospital);
    public Hospital updateHospital(Hospital hospital);
    public Hospital removeHospital(Hospital hospital);
    public List<Hospital> getAllHospital();
    public Hospital getHospitalById(String id);
    public Hospital IsUsername(Hospital hospital);
    public Hospital findByUsernameAndPassword(String username, String password);
}
