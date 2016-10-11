package com.care.health.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.care.health.model.Examination;

public interface ExaminationRepository  extends MongoRepository<Examination, String>{
	 List<Examination> findByStatus(int status);
}
