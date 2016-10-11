package com.care.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.care.health.model.HospitalBrach;

public interface HospitalBrachRepository extends  MongoRepository<HospitalBrach, String> {
	List<HospitalBrach> findByStatus(int status);
}
