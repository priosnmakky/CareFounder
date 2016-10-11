package com.care.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.HospitalBrach;
import com.care.health.model.HospitalBrachDetail;
import com.care.health.model.HospitalDetail;
import com.care.health.repository.HospitalBrachDetailRepository;
import com.care.health.repository.HospitalDetailRepository;
@Service
public class HospitalBrachDetailServicImpl implements HospitalBrachDetailService{
	@Autowired
	HospitalBrachDetailRepository hospitalBrachDetailRepository;
	public HospitalBrachDetail createHospitalBrachDetail(HospitalBrachDetail hospitalBrachDetail) {
		// TODO Auto-generated method stub
		try{
			  return hospitalBrachDetailRepository.save(hospitalBrachDetail);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
		
		
	}

	public HospitalBrachDetail updateHospitalBrachDetail(HospitalBrachDetail hospitalBrachDetail) {
		// TODO Auto-generated method stub
		HospitalBrachDetail hospitalBrachDetailInDb = hospitalBrachDetailRepository.findOne(hospitalBrachDetail.getId());
		  hospitalBrachDetail.setId(hospitalBrachDetailInDb.getId());
		 
	        try{
	            return hospitalBrachDetailRepository.save(hospitalBrachDetail);
	        }catch (Exception e){
	            return null;
	        }
	}

	public void removeHospitalBrachDetail(HospitalBrachDetail hospitalBrachDetail) {
		// TODO Auto-generated method stub
		
		try{
			hospitalBrachDetailRepository.delete(hospitalBrachDetail);

	        }catch (Exception e){
	        System.out.println(e);
	        }
	}

	public List<HospitalBrachDetail> getAllHospitalBrachDetail() {
		// TODO Auto-generated method stub
		try{
			return hospitalBrachDetailRepository.findByStatus(1);

	        }catch (Exception e){
	         return null;
	        }
	
	}

	public HospitalBrachDetail getHospitalBrachDetailById(String id) {
		// TODO Auto-generated method stub
		try{
			return hospitalBrachDetailRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }	
	}

	

}
