package com.hannover.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the patient_claim_details database table.
 * 
 */
@Entity
@Table(name="patient_claim_details")
@NamedQuery(name="PatientClaimDetail.findAll", query="SELECT p FROM PatientClaimDetail p")
public class PatientClaimDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PATIENT_CLAIM_DETAILS_ID_GENERATOR", sequenceName="PATIENT_CLAIM_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_CLAIM_DETAILS_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="admission_date")
	public Date admissionDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name="admission_time")
	public Date admissionTime;

	@Column(name="age_range")
	public String ageRange;

	@Column(name="age_remarks")
	public String ageRemarks;

	@Temporal(TemporalType.DATE)
	@Column(name="discharge_date")
	public Date dischargeDate;

	@Column(name="disease_name")
	public String diseaseName;

	public String gender;

	@Column(name="hospital_name")
	public String hospitalName;

	@Column(name="number_of_days")
	public BigDecimal numberOfDays;

	@Column(name="patient_age")
	public BigDecimal patientAge;

	@Column(name="patient_name")
	public String patientName;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	@Column(name="rule_remarks")
	public String ruleRemarks;

	@Column(name="rule_status")
	public String ruleStatus;

	@Column(name="trend_name")
	public String trendName;

	public String urn;

	@Column(name="upload_details_id")
	public long uploadDetailsId;
	
	

	public PatientClaimDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAdmissionDate() {
		return this.admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	public Date getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Date admissionTime) {
		this.admissionTime = admissionTime;
	}

	public String getAgeRange() {
		return this.ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getAgeRemarks() {
		return this.ageRemarks;
	}

	public void setAgeRemarks(String ageRemarks) {
		this.ageRemarks = ageRemarks;
	}

	public Date getDischargeDate() {
		return this.dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public BigDecimal getNumberOfDays() {
		return this.numberOfDays;
	}

	public void setNumberOfDays(BigDecimal numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public BigDecimal getPatientAge() {
		return this.patientAge;
	}

	public void setPatientAge(BigDecimal patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRfu1() {
		return this.rfu1;
	}

	public void setRfu1(String rfu1) {
		this.rfu1 = rfu1;
	}

	public String getRfu2() {
		return this.rfu2;
	}

	public void setRfu2(String rfu2) {
		this.rfu2 = rfu2;
	}

	public String getRfu3() {
		return this.rfu3;
	}

	public void setRfu3(String rfu3) {
		this.rfu3 = rfu3;
	}

	public String getRuleRemarks() {
		return this.ruleRemarks;
	}

	public void setRuleRemarks(String ruleRemarks) {
		this.ruleRemarks = ruleRemarks;
	}

	public String getRuleStatus() {
		return this.ruleStatus;
	}

	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

	public String getTrendName() {
		return this.trendName;
	}

	public void setTrendName(String trendName) {
		this.trendName = trendName;
	}

	public String getUrn() {
		return this.urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public long getUploadDetailsId() {
		return uploadDetailsId;
	}

	public void setUploadDetailsId(long uploadDetailsId) {
		this.uploadDetailsId = uploadDetailsId;
	}
}