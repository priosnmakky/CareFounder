package com.care.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.care.health.model.Employee;
import com.care.health.model.Hospital;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String>{
	 List<Hospital> findByStatus(int status);
	 Hospital findByUsername(String username);
	 Hospital findByUsernameAndPassword(String username, String password);

}
