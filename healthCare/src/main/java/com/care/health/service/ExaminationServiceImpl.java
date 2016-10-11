package com.care.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.Examination;
import com.care.health.model.HospitalBrach;
import com.care.health.repository.ExaminationRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService{
	@Autowired
	ExaminationRepository examinationRepository;
	public Examination createExamination(Examination examination) {
		// TODO Auto-generated method stub
		try{
			  return examinationRepository.save(examination);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	
	}

	public Examination updateExamination(Examination examination) {
		// TODO Auto-generated method stub
		
		 Examination examinationInDb = examinationRepository.findOne(examination.getId());
		 examination .setId(examinationInDb.getId());
		 
	        try{
	            return examinationRepository.save(examination);
	        }catch (Exception e){
	            return null;
	        }
	}

	public Examination removeExamination(Examination examination) {
		// TODO Auto-generated method stub
		examination.setStatus(2);
		try{
		     return examinationRepository.save(examination);

	        }catch (Exception e){
	         return null;
	        }
	}

	public List<Examination> getAllExamination() {
		// TODO Auto-generated method stub
		try{
			return  examinationRepository.findByStatus(1);

	        }catch (Exception e){
	         return null;
	        }
	
	}

	public Examination getExaminationById(String id) {
		// TODO Auto-generated method stub
		try{
			return examinationRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }
	
	}

}
