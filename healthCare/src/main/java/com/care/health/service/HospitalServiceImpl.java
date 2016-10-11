package com.care.health.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.Hospital;
import com.care.health.repository.HospitalRepository;
@Service
public class HospitalServiceImpl implements HospitalService  {

	@Autowired
	HospitalRepository hospitalRepository ;
	public Hospital createHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		  try{
			  return hospitalRepository.save(hospital);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
		
		
	}

	public Hospital updateHospital(Hospital hospital) {
		// TODO Auto-generated method stu
		  Hospital hospitalInDb = hospitalRepository.findOne(hospital.getId());
		  hospital.setId(hospitalInDb.getId());
		 
	        try{
	            return hospitalRepository.save(hospital);
	        }catch (Exception e){
	            return null;
	        }
		
	}

	public Hospital removeHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		hospital.setStatus(2);
		try{
		     return hospitalRepository.save(hospital);

	        }catch (Exception e){
	         return null;
	        }
		
	}

	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		try{
			return hospitalRepository.findByStatus(1);

	        }catch (Exception e){
	         return null;
	        }
	}

	public Hospital getHospitalById(String id) {
		// TODO Auto-generated method stub
		try{
			return hospitalRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }
	}



	public Hospital IsUsername(Hospital hospital) {
		// TODO Auto-generated method stub
		try{
			return hospitalRepository.findByUsername(hospital.getUsername());

	        }catch (Exception e){
	         return null;
	        }
	}

	public Hospital findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		try{
			return hospitalRepository.findByUsernameAndPassword(username, password);

	        }catch (Exception e){
	         return null;
	        }
		
	}

}
