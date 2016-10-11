package com.care.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.care.health.model.HospitalDetail;

@Repository
public interface HospitalDetailRepository extends MongoRepository<HospitalDetail, String>{
	 List<HospitalDetail> findByStatus(int status);


}
