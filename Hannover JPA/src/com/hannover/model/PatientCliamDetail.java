package com.hannover.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the patient_cliam_details database table.
 * 
 */
@Entity
@Table(name="patient_cliam_details")
@NamedQuery(name="PatientCliamDetail.findAll", query="SELECT p FROM PatientCliamDetail p")
public class PatientCliamDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PATIENT_CLIAM_DETAILS_ID_GENERATOR", sequenceName="PATIENT_CLIAM_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_CLIAM_DETAILS_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="admission_date")
	private Date admissionDate;

	@Column(name="age_range")
	private String ageRange;

	@Column(name="age_remarks")
	private String ageRemarks;

	@Temporal(TemporalType.DATE)
	@Column(name="discharge_date")
	private Date dischargeDate;

	@Column(name="disease_name")
	private String diseaseName;

	@Column(name="hospital_name")
	private String hospitalName;

	@Column(name="number_of_days")
	private BigDecimal numberOfDays;

	@Column(name="patient_age")
	private BigDecimal patientAge;

	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="trend_name")
	private String trendName;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	@Column(name="rule_remarks")
	private String ruleRemarks;

	@Column(name="rule_status")
	private String ruleStatus;

	public PatientCliamDetail() {
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
		return trendName;
	}

	public void setTrendName(String trendName) {
		this.trendName = trendName;
	}

}