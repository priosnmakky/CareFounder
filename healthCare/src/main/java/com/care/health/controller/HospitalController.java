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
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.health.model.Employee;
import com.care.health.model.Hospital;
import com.care.health.model.HospitalDetail;
import com.care.health.model.Image;
import com.care.health.service.HospitalDetailService;
import com.care.health.service.HospitalService;
import com.care.health.service.ImageService;

@Controller
@RequestMapping(value = "/Hospital")
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	@Autowired
    ServletContext context; 
	@Autowired
	ImageService imageService;
	@Autowired
	HospitalDetailService hospitalDetailService;
	@RequestMapping(value = "/drummy",method = RequestMethod.GET)
	public String getDrummy(){
		
	///	System.out.println(context.getRealPath(""));
		Hospital h = new Hospital();
		HospitalDetail hospitalDetail = new HospitalDetail();
		HospitalDetail hospitalDetail1 = new HospitalDetail();
		List<HospitalDetail> k = new ArrayList<HospitalDetail>();
		k.add(hospitalDetail);
		k.add(hospitalDetail1);
		Image image = new Image();
		h.setLogo(image);
		h.setHospitalDetail(k);
	//	hospitalDetailService.get
		return  "";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public @ResponseBody Hospital addHospital(@RequestBody Hospital hospital) throws IOException{
		hospital.setStatus(1);
		hospital.setCreateDate(getCurrentTime());
		
		if(null!=hospital.getHospitalDetail()){
			addHospitalDetail(hospital.getHospitalDetail());
		}
		
		if(null!=hospital&&null!=hospital.getLogo()&&null!=hospital.getLogo().getByteOrpart()){
			String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Hospital\\";
			System.out.println(part);
			Image image = hospital.getLogo();
			hospital.setLogo(null);
			String imageId = hospitalService.createHospital(hospital).getId();
			image.setId(imageId);
			Image returnImage = imageService.createImage(part, image);
			hospital.setLogo(returnImage);
			return hospitalService.updateHospital(hospital);
			
		}
		else{
			return hospitalService.createHospital(hospital);
		}	
		
		
	}
	
	@RequestMapping(value = "/IsUsername",method = RequestMethod.POST)
	public @ResponseBody Hospital IsUsername(@RequestBody Hospital hospital) throws IOException{
		Hospital returnHospital = hospitalService.IsUsername(hospital);
		return returnHospital;
	}
	
	@RequestMapping(value = "/Login",method = RequestMethod.POST)
	public @ResponseBody Hospital getLogin(@RequestBody Hospital hospital) throws IOException{
		Hospital returnHospital = hospitalService.findByUsernameAndPassword(hospital.getUsername(),hospital.getPassword());
		return returnHospital;
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public  @ResponseBody Hospital  updateHospital(@RequestBody Hospital hospital) throws IOException{
		
		hospital.setUpdateDate(getCurrentTime());
		Hospital oldHospital =  hospitalService.getHospitalById(hospital.getId());
		///ถ้าhospital.getHospitalDetail() เท่ากับ null แสดงว่าๆม่update ถ้า
		if(null!=hospital.getHospitalDetail()){
			updateHospitalDetail(oldHospital.getHospitalDetail(), hospital.getHospitalDetail());
		}
		if(null!=hospital&&null!=hospital.getLogo()&&null!=hospital.getLogo().getByteOrpart()){
			String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Employee\\";
			Hospital getHospital  = hospitalService.getHospitalById(hospital.getId());
			imageService.removeImage(getHospital.getLogo()); 
			hospital.getLogo().setId(hospital.getId());
			Image image = imageService.createImage(part,hospital.getLogo());
			hospital.setLogo(image);
			return hospitalService.updateHospital(hospital);
			
		}
		else{
			return hospitalService.updateHospital(hospital);
			
		}
	}
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody Hospital  deleteHospitale(@PathVariable("id") String id){
		Hospital hospital =hospitalService.getHospitalById(id);
		if(null!=hospital.getHospitalDetail()){
			deleteHospitalDetail(hospital.getHospitalDetail());
		}
		Hospital returnHospital =  hospitalService.removeHospital(hospital);
		if(null!=returnHospital&&null!=returnHospital.getLogo()&&null!=returnHospital.getLogo().getByteOrpart()){
			String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Employee\\";
			imageService.removeImage(returnHospital.getLogo()); 
		}
		
		return returnHospital;
	}
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	    public @ResponseBody List<Hospital> getAllHospital() throws IOException{
		 List<Hospital> hospitals = hospitalService.getAllHospital();
		 
		 for(int i=0;i<hospitals.size();i++){
			 if(null!=hospitals.get(i).getHospitalDetail()){
			  getAllHospitalDetail(hospitals.get(i).getHospitalDetail());
			 }
			 if(null!=hospitals.get(i).getLogo()&&null!=hospitals.get(i).getLogo().getByteOrpart()){
				 hospitals.get(i).setLogo(imageService.getImagefile(hospitals.get(i).getLogo()));
			 }
		}
		 return hospitals;
	 }
	 @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
		public @ResponseBody Hospital getHospitalById(@PathVariable("id") String id) throws IOException{
		 	Hospital hospital = hospitalService.getHospitalById(id);
		 	 if(null!=hospital.getLogo()&&null!=hospital.getLogo().getByteOrpart()){
				 hospital.setLogo(imageService.getImagefile(hospital.getLogo()));
			 }
		 	if(null!=hospital.getHospitalDetail()){
				  getAllHospitalDetail(hospital.getHospitalDetail());
			}
		 	return hospital;
		}
	 
	public List<HospitalDetail> addHospitalDetail(List<HospitalDetail> hospitalDetails){
		Date currentdate = getCurrentTime();
			for(int i=0;i<hospitalDetails.size();i++){
				hospitalDetails.get(i).setStatus(1);
				hospitalDetails.get(i).setCreateDate(currentdate );
				hospitalDetailService.createHospitalDetail(hospitalDetails.get(i));
				hospitalDetails.get(i).setName(null);
				hospitalDetails.get(i).setDetail(null);
				hospitalDetails.get(i).setCreateDate(null);
				hospitalDetails.get(i).setUpdateDate(null);
				hospitalDetails.get(i).setWord(null);
				hospitalDetails.get(i).setStatus(null);
			}
			
			return hospitalDetails;
		}
	public List<HospitalDetail> updateHospitalDetail(List<HospitalDetail> oldhospitalDetails,List<HospitalDetail> newhospitalDetails){
		List<HospitalDetail> hospitalDetails = new ArrayList<HospitalDetail>();
		Boolean IsHospitalDetail = true;
		for(int i=0;i<newhospitalDetails.size();i++)
		{
			if(null!=newhospitalDetails.get(i).getId()){
				System.out.println("makky1");
				hospitalDetailService.updateHospitalDetail(newhospitalDetails.get(i));
				newhospitalDetails.get(i).setName(null);
				newhospitalDetails.get(i).setDetail(null);
				newhospitalDetails.get(i).setCreateDate(null);
				newhospitalDetails.get(i).setUpdateDate(null);
				newhospitalDetails.get(i).setWord(null);
				newhospitalDetails.get(i).setStatus(null);
				//hospitalDetails.add(newhospitalDetails.get(i));
			}
			else{
				System.out.println("makky2");
				hospitalDetailService.createHospitalDetail(newhospitalDetails.get(i));
				newhospitalDetails.get(i).setName(null);
				newhospitalDetails.get(i).setDetail(null);
				newhospitalDetails.get(i).setCreateDate(null);
				newhospitalDetails.get(i).setUpdateDate(null);
				newhospitalDetails.get(i).setWord(null);
				newhospitalDetails.get(i).setStatus(null);
				//hospitalDetails.add(newhospitalDetails.get(i));
			}
		}
		Boolean IsHospitalDetail1 = true;
		for(int i=0;i<oldhospitalDetails.size();i++){
			for(int x=0;x<newhospitalDetails.size();x++){
				if(oldhospitalDetails.get(i).getId().equals(newhospitalDetails.get(x).getId())){
					IsHospitalDetail1=false;
				}
				
			}
			if(IsHospitalDetail1){
				System.out.println("makky3");
				hospitalDetailService.removeHospitalDetail(oldhospitalDetails.get(i));
			}
			IsHospitalDetail1=true;
		}
	//	HospitalDetail hospitalDetail = new HospitalDetail();
		//hospitalDetails.add(hospitalDetail);
return hospitalDetails;
	}
			
//		    HospitalDetail hospitalDetail =	hospitalDetailService.getHospitalDetailById(hospitalDetails.get(i).getId());
//			if(null!=hospitalDetail){
//			//if(hospitalDetail.getStatus()==1){	
//		    hospitalDetail.setUpdateDate(currentdate);
//		    System.out.println("makky");
//			hospitalDetailService.updateHospitalDetail(hospitalDetails.get(i));
//		///	}else{
//				System.out.println("makky2");
//				hospitalDetailService.removeHospitalDetail(hospitalDetail);
//				hospitalDetails.remove(i);
//		///	}
//			}
//			else{
//				System.out.println("makky3");
//				hospitalDetailService.createHospitalDetail(hospitalDetails.get(i));
//				hospitalDetails.get(i).setName(null);
//				hospitalDetails.get(i).setDetail(null);
//				hospitalDetails.get(i).setCreateDate(null);
//				hospitalDetails.get(i).setUpdateDate(null);
//				hospitalDetails.get(i).setWord(null);
//				hospitalDetails.get(i).setStatus(null);
//			}
//		
		
		
		//return hospitalDetails;
	
	public List<HospitalDetail> deleteHospitalDetail(List<HospitalDetail> hospitalDetails){
		for(int i=0;i<hospitalDetails.size();i++){
		///	hospitalDetails.get(i).setStatus(2);
			hospitalDetailService.removeHospitalDetail(hospitalDetails.get(i));
		}
		return hospitalDetails;
	}
	public List<HospitalDetail> getAllHospitalDetail(List<HospitalDetail> hospitalDetails){
		for(int i=0;i<hospitalDetails.size();i++){
			hospitalDetails.set(i,hospitalDetailService.getHospitalDetailById(hospitalDetails.get(i).getId()));
		}
		return hospitalDetails;
	}
	
	public Date getCurrentTime(){
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
		return calendar.getTime();
		
	}
//	
//	
	
}
