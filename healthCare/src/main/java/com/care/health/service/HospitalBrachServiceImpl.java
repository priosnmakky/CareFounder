package com.care.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.HospitalBrach;
import com.care.health.model.HospitalDetail;
import com.care.health.repository.EmployeeRepository;
import com.care.health.repository.HospitalBrachRepository;
import com.care.health.repository.HospitalRepository;
@Service
public class HospitalBrachServiceImpl implements HospitalBrachService {
	@Autowired
	HospitalBrachRepository hospitalBrachRepository;
	public HospitalBrach createHospitalBrach(HospitalBrach hospitalBrach) {
		// TODO Auto-generated method stub
		  try{
			  return hospitalBrachRepository.save(hospitalBrach);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	}

	public HospitalBrach updateHospitalBrach(HospitalBrach hospitalBrach) {
		// TODO Auto-generated method stub
		 HospitalBrach hospitalBrachInDb = hospitalBrachRepository.findOne(hospitalBrach.getId());
		 hospitalBrach .setId(hospitalBrachInDb.getId());
		 
	        try{
	            return hospitalBrachRepository.save(hospitalBrach);
	        }catch (Exception e){
	            return null;
	        }
		
	
	}

	public HospitalBrach removeHospitalBrach(HospitalBrach hospitalBrach) {
		// TODO Auto-generated method stub
		hospitalBrach.setStatus(2);
		try{
		     return hospitalBrachRepository.save(hospitalBrach);

	        }catch (Exception e){
	         return null;
	        }
		
	}

	public List<HospitalBrach> getAllHospitalBrach() {
		// TODO Auto-generated method stub
		try{
			return hospitalBrachRepository.findByStatus(1);

	        }catch (Exception e){
	         return null;
	        }
		
	}

	public HospitalBrach getHospitalBrachById(String id) {
		// TODO Auto-generated method stub
		try{
			return hospitalBrachRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }
	}
	


}
