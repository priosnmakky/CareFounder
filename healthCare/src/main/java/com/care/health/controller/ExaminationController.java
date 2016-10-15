package com.care.health.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.tree.DefaultMutableTreeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.health.model.Address;
import com.care.health.model.Examination;
import com.care.health.model.ExaminationDetail;
import com.care.health.model.Hospital;
import com.care.health.model.HospitalBrach;
import com.care.health.model.HospitalBrachDetail;
import com.care.health.model.Image;
import com.care.health.service.ExaminationDetailService;
import com.care.health.service.ExaminationService;

@Controller
@RequestMapping(value = "/Examination")
public class ExaminationController {
	@Autowired
	ExaminationService examinationService;
	@Autowired
	ExaminationDetailService examinationDetailService;
	@RequestMapping(value = "/drummy",method = RequestMethod.GET)
	public @ResponseBody Examination getDrummy(){
		
	///	System.out.println(context.getRealPath(""));
		Examination examination = new Examination();
		examination.setId("makky");
		examination.setSciName("test");
		Examination examination2 = new Examination();
		
		ExaminationDetail examinationDetail = new ExaminationDetail();
		List<ExaminationDetail> examExaminations = new ArrayList<ExaminationDetail>();
		examExaminations.add(examinationDetail);
		 DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Examination());
		examination.setExamChild(examExaminations);
		examination.setExaminationDetails(examExaminations);
		return  examination;
	}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public @ResponseBody Examination addExamination(@RequestBody Examination examination) throws IOException{
		
		traversel(examination);
//		examination.setStatus(1);
//		examination.setCreateDate(getCurrentTime());
//		
//		if(null!=examination.getExaminationDetails()){
//			addExaminationhDetail(examination.getExaminationDetails());
//		}
//		return examinationService.createExamination(examination);
//	
		

		
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public  @ResponseBody Examination  updateExamination(@RequestBody Examination examination) throws IOException{
		
		examination.setUpdateDate(getCurrentTime());
		Examination oldExamination =  examinationService.getExaminationById(examination.getId());
		///ถ้าhospital.getHospitalDetail() เท่ากับ null แสดงว่าๆม่update ถ้า
		if(null!=examination.getExaminationDetails()){
			updateExaminationDetail(oldExamination.getExaminationDetails(), examination.getExaminationDetails());
		}
		
		
			return examinationService.updateExamination(examination);
			
		
	}
	
	

	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody Examination  deleteExamination(@PathVariable("id") String id){
		Examination examination =examinationService.getExaminationById(id);
		if(null!=examination.getExaminationDetails()){
			deleteExaminationDetail(examination.getExaminationDetails());
		}
		Examination returnExamination = examinationService.removeExamination(examination);
		
		return returnExamination;
	}
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody List<Examination> getAllExamination() throws IOException{
	 List<Examination> examinations = examinationService.getAllExamination();
	for(int i=0;i<examinations.size();i++){
		getAllExaminationDetail(examinations.get(i).getExaminationDetails());
	}
	
	 return examinations;
 }
	@RequestMapping(value = "/addTree",method = RequestMethod.POST)
	public @ResponseBody List<Examination> addExaminationList(@RequestBody ArrayList<Examination> examinations) throws IOException{
		
	
		return examinations;
	}
	
	public List<ExaminationDetail> addExaminationhDetail(List<ExaminationDetail> examinationDetails){
		Date currentdate = getCurrentTime();
			for(int i=0;i<examinationDetails.size();i++){
				examinationDetails.get(i).setCreateDate(currentdate);
				examinationDetailService.createExaminationDetail(examinationDetails.get(i));
				examinationDetails.get(i).setName(null);
				examinationDetails.get(i).setDetail(null);
				examinationDetails.get(i).setWord(null);
			
			}
			
			return examinationDetails;
		}
public List<ExaminationDetail> updateExaminationDetail(List<ExaminationDetail> oldExaminationDetail,List<ExaminationDetail> newExaminationDetail){
		
		for(int i=0;i<newExaminationDetail.size();i++)
		{
			if(null!=newExaminationDetail.get(i).getId()){
				System.out.println("makky1");
				examinationDetailService.updateExaminationDetail(newExaminationDetail.get(i));
				newExaminationDetail.get(i).setName(null);
				newExaminationDetail.get(i).setDetail(null);
				newExaminationDetail.get(i).setCreateDate(null);
				newExaminationDetail.get(i).setWord(null);
				
				//hospitalDetails.add(newhospitalDetails.get(i));
			}
			else{
				System.out.println("makky2");
				examinationDetailService.createExaminationDetail(newExaminationDetail.get(i));
				newExaminationDetail.get(i).setName(null);
				newExaminationDetail.get(i).setDetail(null);
				newExaminationDetail.get(i).setCreateDate(null);
				newExaminationDetail.get(i).setWord(null);
				
			}
		}
		Boolean IsExaminationDetail = true;
		for(int i=0;i<oldExaminationDetail.size();i++){
			for(int x=0;x<newExaminationDetail.size();x++){
				if(oldExaminationDetail.get(i).getId().equals(newExaminationDetail.get(x).getId())){
					IsExaminationDetail =false;
				}
				
			}
			if(IsExaminationDetail ){
				System.out.println("makky3");
				examinationDetailService.removeExaminationDetail(oldExaminationDetail.get(i));
			}
			IsExaminationDetail =true;
		}
//		HospitalDetail hospitalDetail = new HospitalDetail();
		//hospitalDetails.add(hospitalDetail);
	return newExaminationDetail;
	}
	public List<ExaminationDetail> deleteExaminationDetail(List<ExaminationDetail> examinationDetails){
		for(int i=0;i<examinationDetails.size();i++){
	///	hospitalDetails.get(i).setStatus(2);
		examinationDetailService.removeExaminationDetail(examinationDetails.get(i));
		
		}
	return examinationDetails;
	}
	public List<ExaminationDetail> getAllExaminationDetail(List<ExaminationDetail> examinationDetails){
		for(int i=0;i<examinationDetails.size();i++){
			examinationDetails.set(i,examinationDetailService.getExaminationDetailById(examinationDetails.get(i).getId()));
					
					
		}
		return examinationDetails;
	}
	
	public void traversel(Examination rootExamination)//depth first
	{
		
	
		System.out.println(rootExamination.getSciName());
		if(null!=examinationService.getExaminationById(rootExamination.getId())){
			rootExamination.setStatus(1);
			rootExamination.setCreateDate(getCurrentTime());
//			
			if(null!=rootExamination.getExaminationDetails()){
				addExaminationhDetail(rootExamination.getExaminationDetails());
			}
			examinationService.createExamination(rootExamination);
		}
		
	    if(null!=rootExamination.getExamChild()){
	    if(rootExamination.getExamChild().size()!=0)
	        for(int i=0;i<rootExamination.getExamChild().size();i++)
	        	  traversel((Examination)rootExamination.getExamChild().get(i));
	    }
	}

	
	public Date getCurrentTime(){
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		return calendar.getTime();
		
	}
	
	
}
