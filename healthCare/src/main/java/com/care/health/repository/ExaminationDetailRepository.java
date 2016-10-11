package com.care.health.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.care.health.model.ExaminationDetail;
import com.care.health.model.HospitalBrachDetail;

public interface ExaminationDetailRepository extends MongoRepository<ExaminationDetail, String>{
	
}
