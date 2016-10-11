package com.care.health.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.health.model.Address;
import com.care.health.model.Examination;
import com.care.health.model.ExaminationDetail;
import com.care.health.model.HospitalBrach;
import com.care.health.model.HospitalBrachDetail;
import com.care.health.service.ExaminationService;

@Controller
@RequestMapping(value = "/Examination")
public class ExaminationController {
	@Autowired
	ExaminationService examinationService;
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
		examination.setExaminationDetails(examExaminations);
		return  examination;
	}

}
