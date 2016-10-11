package com.care.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.health.model.Examination;
import com.care.health.model.ExaminationDetail;
import com.care.health.repository.ExaminationDetailRepository;
import com.care.health.repository.ExaminationRepository;
@Service
public class ExaminationDetailServiceImpl implements ExaminationDetailService{
	@Autowired
	ExaminationDetailRepository examinationDetailRepository;

	public ExaminationDetail createExaminationDetail(ExaminationDetail examinationDetail) {
		// TODO Auto-generated method stub
		try{
			  return examinationDetailRepository.save(examinationDetail);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
		
	}

	public ExaminationDetail updateExaminationDetail(ExaminationDetail examinationDetail) {
		// TODO Auto-generated method stub
		 ExaminationDetail examinationDetailInDb = examinationDetailRepository.findOne(examinationDetail.getId());
		 examinationDetail.setId(examinationDetailInDb.getId());
		 
	        try{
	            return examinationDetailRepository.save(examinationDetail);
	        }catch (Exception e){
	            return null;
	        }
		
	}

	public void removeExaminationDetail(ExaminationDetail examinationDetail) {
		// TODO Auto-generated method stub
		
		try{
		     examinationDetailRepository.delete(examinationDetail);

	        }catch (Exception e){
	         
	        }
		
	}

	public List<ExaminationDetail> getAllExaminationDetail() {
		// TODO Auto-generated method stub
		try{
			return  examinationDetailRepository.findAll();

	        }catch (Exception e){
	         return null;
	        }

	
	}

	public ExaminationDetail getExaminationDetailById(String id) {
		// TODO Auto-generated method stub
		try{
			return examinationDetailRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }
	
	
	}

}
