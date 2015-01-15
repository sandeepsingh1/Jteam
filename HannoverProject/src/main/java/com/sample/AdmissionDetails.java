package com.sample;

import java.util.Date;

public class AdmissionDetails {
	public String diseaseName;
	public Integer duration;
	public String urn;
	public String patientName;
	public Date admissionDate;
	public Date dischargeDate;
	public Boolean validationStatus = true;
	public String validationReponse;
	
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getUrn() {
		return urn;
	}
	public void setUrn(String urn) {
		this.urn = urn;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public Boolean getValidationStatus() {
		return validationStatus;
	}
	public void setValidationStatus(Boolean validationStatus) {
		this.validationStatus = validationStatus;
	}
	public String getValidationReponse() {
		return validationReponse;
	}
	public void setValidationReponse(String validationReponse) {
		this.validationReponse = validationReponse;
	}
	@Override
	public String toString() {
		return "AdmissionDetails [diseaseName=" + diseaseName + ", duration="
				+ duration + ", urn=" + urn + ", patientName=" + patientName
				+ ", admissionDate=" + admissionDate + ", dischargeDate="
				+ dischargeDate + "]";
	}

}
