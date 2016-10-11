package com.care.health.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.health.model.Address;
import com.care.health.model.Hospital;
import com.care.health.model.HospitalBrach;
import com.care.health.model.HospitalBrachDetail;
import com.care.health.model.HospitalDetail;
import com.care.health.model.Image;
import com.care.health.service.HospitalBrachDetailService;
import com.care.health.service.HospitalBrachService;
import com.care.health.service.HospitalService;

@Controller
@RequestMapping(value = "/HospitalBrach")
public class HospitalBrachController {
	@Autowired
	HospitalBrachService hospitalBrachService;
	@Autowired
	HospitalBrachDetailService hospitalBrachDetailService ;
	@Autowired
    ServletContext context; 
	@RequestMapping(value = "/drummy",method = RequestMethod.GET)
	public @ResponseBody HospitalBrach getDrummy(){
		
	///	System.out.println(context.getRealPath(""));
		HospitalBrach hospitalBrach = new HospitalBrach();
		hospitalBrach.setId("asdsad");
		hospitalBrach.setTel("mmmmmmmm");
		hospitalBrach.setFax("asdadas");
		hospitalBrach.setFacebook("sdsdsdd");
		hospitalBrach.setTwitter("makky");
		List<Address> addresses = new ArrayList<Address>(); 
		Address address = new Address();
		addresses.add(address);
		hospitalBrach.setAddress(addresses);
		List<HospitalBrachDetail> hospitalBrachDetails = new ArrayList<HospitalBrachDetail>();
		HospitalBrachDetail hospitalBrachDetail = new HospitalBrachDetail();
		hospitalBrachDetails.add(hospitalBrachDetail);
		hospitalBrach.setHospitalBrachDetails(hospitalBrachDetails);
		hospitalBrach.setCreateDate(new Date());
		hospitalBrach.setUpdateDate(new Date());
		
		return  hospitalBrach;
	}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public @ResponseBody HospitalBrach addHospitalBrach(@RequestBody HospitalBrach hospitalBrach ) throws IOException{
		hospitalBrach.setStatus(1);
		hospitalBrach.setCreateDate(getCurrentTime());
		
		if(null!=hospitalBrach.getHospitalBrachDetails()){
			addHospitalBrachDetail(hospitalBrach.getHospitalBrachDetails());
		}
		return hospitalBrachService.createHospitalBrach(hospitalBrach);
	
		
	}
	
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public  @ResponseBody HospitalBrach  updateHospital(@RequestBody HospitalBrach hospitalBrach) throws IOException{
		
		hospitalBrach.setUpdateDate(getCurrentTime());
		HospitalBrach oldHospitalBrach =  hospitalBrachService.getHospitalBrachById(hospitalBrach.getId());
		///ถ้าhospital.getHospitalDetail() เท่ากับ null แสดงว่าๆม่update ถ้า
		if(null!=hospitalBrach.getHospitalBrachDetails()){
			updateHospitalBrachDetail(oldHospitalBrach.getHospitalBrachDetails(), hospitalBrach.getHospitalBrachDetails());
		}
		
		
			return hospitalBrachService.updateHospitalBrach(hospitalBrach);
			
		
	}
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody HospitalBrach  deleteHospitaleBrach(@PathVariable("id") String id){
		HospitalBrach hospitalBrach =hospitalBrachService.getHospitalBrachById(id);
		if(null!=hospitalBrach.getHospitalBrachDetails()){
			deleteHospitalBrachDetail(hospitalBrach.getHospitalBrachDetails());
		}
		HospitalBrach returnHospitalBrach = hospitalBrachService.removeHospitalBrach(hospitalBrach);
		
		return returnHospitalBrach;
	}
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	    public @ResponseBody List<HospitalBrach> getAllHospital() throws IOException{
		 List<HospitalBrach> hospitalBraches = hospitalBrachService.getAllHospitalBrach();
		
		
		 return hospitalBraches;
	 }
public List<HospitalBrachDetail> addHospitalBrachDetail(List<HospitalBrachDetail> hospitalBrachDetails){
	Date currentdate = getCurrentTime();
		for(int i=0;i<hospitalBrachDetails.size();i++){
			hospitalBrachDetails.get(i).setStatus(1);
			hospitalBrachDetails.get(i).setCreateDate(currentdate );
			hospitalBrachDetailService.createHospitalBrachDetail(hospitalBrachDetails.get(i));
			hospitalBrachDetails.get(i).setName(null);
			hospitalBrachDetails.get(i).setDetail(null);
			hospitalBrachDetails.get(i).setCreateDate(null);
			hospitalBrachDetails.get(i).setUpdateDate(null);
			hospitalBrachDetails.get(i).setWord(null);
			hospitalBrachDetails.get(i).setStatus(null);
		}
		
		return hospitalBrachDetails;
	}
public List<HospitalBrachDetail> updateHospitalBrachDetail(List<HospitalBrachDetail> oldhospitalBrachDetails,List<HospitalBrachDetail> newhospitalBrachDetails){
	List<HospitalBrachDetail> hospitalBrachDetails = new ArrayList<HospitalBrachDetail>();
	Boolean IsHospitalBrachDetail = true;
	for(int i=0;i<newhospitalBrachDetails.size();i++)
	{
		if(null!=newhospitalBrachDetails.get(i).getId()){
			System.out.println("makky1");
			hospitalBrachDetailService.updateHospitalBrachDetail(newhospitalBrachDetails.get(i));
			newhospitalBrachDetails.get(i).setName(null);
			newhospitalBrachDetails.get(i).setDetail(null);
			newhospitalBrachDetails.get(i).setCreateDate(null);
			newhospitalBrachDetails.get(i).setUpdateDate(null);
			newhospitalBrachDetails.get(i).setWord(null);
			newhospitalBrachDetails.get(i).setStatus(null);
			//hospitalDetails.add(newhospitalDetails.get(i));
		}
		else{
			System.out.println("makky2");
			hospitalBrachDetailService.createHospitalBrachDetail(newhospitalBrachDetails.get(i));
			newhospitalBrachDetails.get(i).setName(null);
			newhospitalBrachDetails.get(i).setDetail(null);
			newhospitalBrachDetails.get(i).setCreateDate(null);
			newhospitalBrachDetails.get(i).setUpdateDate(null);
			newhospitalBrachDetails.get(i).setWord(null);
			newhospitalBrachDetails.get(i).setStatus(null);
			//hospitalDetails.add(newhospitalDetails.get(i));
		}
	}
	Boolean IsHospitalBrachDetail1 = true;
	for(int i=0;i<oldhospitalBrachDetails.size();i++){
		for(int x=0;x<newhospitalBrachDetails.size();x++){
			if(oldhospitalBrachDetails.get(i).getId().equals(newhospitalBrachDetails.get(x).getId())){
				IsHospitalBrachDetail1=false;
			}
			
		}
		if(IsHospitalBrachDetail1){
			System.out.println("makky3");
			hospitalBrachDetailService.removeHospitalBrachDetail(oldhospitalBrachDetails.get(i));
		}
		IsHospitalBrachDetail1=true;
	}
	
//	HospitalDetail hospitalDetail = new HospitalDetail();
	//hospitalDetails.add(hospitalDetail);
return hospitalBrachDetails;
}
public List<HospitalBrachDetail> deleteHospitalBrachDetail(List<HospitalBrachDetail> hospitalBrachDetails){
	for(int i=0;i<hospitalBrachDetails.size();i++){
	///	hospitalDetails.get(i).setStatus(2);
		hospitalBrachDetailService.removeHospitalBrachDetail(hospitalBrachDetails.get(i));
	}
	return hospitalBrachDetails;
}
	public Date getCurrentTime(){
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
		return calendar.getTime();
		
	}
	
	
}
