package com.care.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.Hospital;
import com.care.health.model.HospitalDetail;
import com.care.health.repository.EmployeeRepository;
import com.care.health.repository.HospitalDetailRepository;
@Service
public class HospitalDetailServiceImpl implements HospitalDetailService {
	@Autowired
	HospitalDetailRepository hospitalDetailRepository;
	public HospitalDetail createHospitalDetail(HospitalDetail hospitalDetail) {
		// TODO Auto-generated method stub
		  try{
			  return hospitalDetailRepository.save(hospitalDetail);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
		
		
	}

	public HospitalDetail updateHospitalDetail(HospitalDetail hospitalDetail) {
		// TODO Auto-generated method stu
		  HospitalDetail hospitalDetailInDb = hospitalDetailRepository.findOne(hospitalDetail.getId());
		  hospitalDetail.setId(hospitalDetailInDb.getId());
		 
	        try{
	            return hospitalDetailRepository.save(hospitalDetail);
	        }catch (Exception e){
	            return null;
	        }
		
	}

	public void removeHospitalDetail(HospitalDetail hospitalDetail) {
		// TODO Auto-generated method stub
		
		try{
		    hospitalDetailRepository.delete(hospitalDetail);

	        }catch (Exception e){
	        System.out.println(e);
	        }
		
	}

	public List<HospitalDetail> getAllHospitalDetail() {
		// TODO Auto-generated method stub
		try{
			return hospitalDetailRepository.findByStatus(1);

	        }catch (Exception e){
	         return null;
	        }
	}

	public HospitalDetail getHospitalDetailById(String id) {
		// TODO Auto-generated method stub
		try{
			return hospitalDetailRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }
	}






	

}
