package com.care.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.care.health.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	 List<Employee> findByStatus(int status);
	 Employee findByUsername(String username);
	 Employee findByUsernameAndPassword(String username, String password);

}
