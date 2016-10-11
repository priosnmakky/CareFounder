package com.care.health.service;

import java.util.List;

import com.care.health.model.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee removeEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(String id);
    public Employee IsUsername(Employee employee);
    public Employee findByUsernameAndPassoword(String username,String password);
}
