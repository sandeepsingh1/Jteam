package com.hannover.service;

import java.util.List;

import com.hannover.model.PatientClaimDetail;
import com.hannover.model.UploadDetail;

public interface SaveExcelService {
	public void createPatientCliamDetails(List<PatientClaimDetail> pcdList);
	public List<PatientClaimDetail> getFailedTrends();
	public UploadDetail uploadFileDetails(UploadDetail uploadDetail);
	public UploadDetail updateUploadFileDetails(UploadDetail uploadDetail);
	public String getCSVFileData(String state, String year, String month);
	public UploadDetail getUploadData(String state, String year, String month);
	public String getPieData(Long uploadDetailsId);
}
