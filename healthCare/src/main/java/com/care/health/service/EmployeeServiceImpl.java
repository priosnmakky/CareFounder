package com.care.health.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.care.health.model.Employee;
import com.care.health.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository ;
	
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		  try{
			  return employeeRepository.save(employee);

	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
		
		
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		  Employee employeeInDb = employeeRepository.findOne(employee.getId());
		  employee.setId(employeeInDb.getId());
		 
	        try{
	            return employeeRepository.save(employee);
	        }catch (Exception e){
	            return null;
	        }
		
	}

	public Employee removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setStatus(2);
		try{
		     return employeeRepository.save(employee);

	        }catch (Exception e){
	         return null;
	        }
		
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		try{
			return employeeRepository.findByStatus(1);

	        }catch (Exception e){
	         return null;
	        }
	}

	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		try{
			return employeeRepository.findOne(id);

	        }catch (Exception e){
	         return null;
	        }
	}



	public Employee IsUsername(Employee employee) {
		// TODO Auto-generated method stub
		try{
			return employeeRepository.findByUsername(employee.getUsername());

	        }catch (Exception e){
	         return null;
	        }
	}

	public Employee findByUsernameAndPassoword(String username, String password) {
		// TODO Auto-generated method stub
		try{
			return employeeRepository.findByUsernameAndPassword(username, password);

	        }catch (Exception e){
	         return null;
	        }
	
	}
	

}
