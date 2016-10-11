package com.care.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.care.health.model.HospitalBrachDetail;

public interface HospitalBrachDetailRepository  extends  MongoRepository<HospitalBrachDetail, String>{
	List<HospitalBrachDetail> findByStatus(int status);
}
