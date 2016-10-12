package com.care.health.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.care.health.model.Employee;
import com.care.health.model.Image;
import com.care.health.service.EmployeeService;
import com.care.health.service.ImageService;



@Controller
@RequestMapping(value = "/Employee")
@Secured("ROLE_ADMIN")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ImageService imageService;
	@Autowired
    ServletContext context; 
	@RequestMapping(value = "/drummy",method = RequestMethod.GET)
	public @ResponseBody Employee getDrummy(){
		
		System.out.println(context.getRealPath(""));
		Employee em = new Employee();
		Image image = new Image();
		em.setPicture(image);
		return  em;
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public @ResponseBody Employee addEmployee(@RequestBody Employee employee) throws IOException{
		employee.setStatus(1);
		employee.setCreateDate(getCurrentTime());
		if(null!=employee&&null!=employee.getPicture()&&null!=employee.getPicture().getByteOrpart()){
			String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Employee\\";
			System.out.println(part);
			Image image = employee.getPicture();
			employee.setPicture(null);
			String imageId = employeeService.createEmployee(employee).getId();
			image.setId(imageId);
			Image returnImage = imageService.createImage(part, image);
			employee.setPicture(returnImage);
			return employeeService.updateEmployee(employee);
			
		}
		else{
			return employeeService.createEmployee(employee);
		}
		
		
		

		
	}
	
	
	
	@RequestMapping(value = "/IsUsername",method = RequestMethod.POST)
	public @ResponseBody Employee IsUsername(@RequestBody Employee employee) throws IOException{
		Employee returnEmployee = employeeService.IsUsername(employee);
		return returnEmployee;
	}
	@RequestMapping(value = "/Login",method = RequestMethod.POST)
	public @ResponseBody Employee getLogin(@RequestBody Employee employee) throws IOException{
		Employee returnEmployee = employeeService.findByUsernameAndPassoword(employee.getUsername(), employee.getPassword());
		return returnEmployee;
	}
	
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public  @ResponseBody Employee  updateEmployee(@RequestBody Employee employee) throws IOException{
		
		
		employee.setUpdateDate(getCurrentTime());
		if(null!=employee&&null!=employee.getPicture()&&null!=employee.getPicture().getByteOrpart()){
			String part = context.getRealPath("")+"WEB-INF\\resource\\image\\Employee\\";
			Employee getEmployee  = employeeService.getEmployeeById(employee.getId());
			imageService.removeImage(getEmployee.getPicture()); 
			employee.getPicture().setId(employee.getId());
			Image image = imageService.createImage(part,employee.getPicture());
			employee.setPicture(image);
			return employeeService.updateEmployee(employee);
			
		}
		else{
			return employeeService.updateEmployee(employee);
			
		}
	}
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody Employee  deleteEmployee(@PathVariable("id") String id){
		Employee employee =employeeService.getEmployeeById(id);
		Employee returnEmployee =  employeeService.removeEmployee(employee);
		if(null!=returnEmployee&&null!=returnEmployee.getPicture()&&null!=returnEmployee.getPicture().getByteOrpart()){
			imageService.removeImage(returnEmployee.getPicture()); 
		}
		
		return returnEmployee;
	}
//	
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	    public @ResponseBody List<Employee> getAllEmployee() throws IOException{
		 List<Employee> employees = employeeService.getAllEmployee();
		 for(int i=0;i<employees.size();i++){
			 if(null!=employees.get(i).getPicture()&&null!=employees.get(i).getPicture().getByteOrpart()){
			 employees.get(i).setPicture(imageService.getImagefile(employees.get(i).getPicture()));
			 }
		}
		 return employees;
	 }
	public Date getCurrentTime(){
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		return calendar.getTime();
		
	}
//	
	
}
