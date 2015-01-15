package com.hannover.service;

import java.util.List;

import com.hannover.model.PatientCliamDetail;

public interface SaveExcelService {
	public void createPatientCliamDetails(List<PatientCliamDetail> pcdList);
	public List<PatientCliamDetail> getFailedTrends();
}
