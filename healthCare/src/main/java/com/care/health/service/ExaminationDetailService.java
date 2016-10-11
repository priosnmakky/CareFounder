package com.care.health.service;

import java.util.List;

import com.care.health.model.ExaminationDetail;
import com.care.health.model.HospitalBrachDetail;

public interface ExaminationDetailService {

	public ExaminationDetail createExaminationDetail(ExaminationDetail examinationDetail);
    public ExaminationDetail updateExaminationDetail(ExaminationDetail examinationDetail);
    public void removeExaminationDetail(ExaminationDetail examinationDetail);
    public List<ExaminationDetail> getAllExaminationDetail();
    public ExaminationDetail getExaminationDetailById(String id);
}
