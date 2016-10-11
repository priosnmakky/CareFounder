package com.care.health.service;

import java.util.List;

import com.care.health.model.Examination;
import com.care.health.model.Hospital;

public interface ExaminationService {
	public Examination createExamination(Examination examination);
    public Examination updateExamination(Examination examination);
    public Examination removeExamination(Examination examination);
    public List<Examination> getAllExamination();
    public Examination getExaminationById(String id);
  
}
