package com.hannover.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the admission_details database table.
 * 
 */
@Entity
@Table(name="admission_details")
@NamedQuery(name="AdmissionDetail.findAll", query="SELECT a FROM AdmissionDetail a")
public class AdmissionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADMISSION_DETAILS_ADMISSIONID_GENERATOR", sequenceName="ADMISSION_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADMISSION_DETAILS_ADMISSIONID_GENERATOR")
	@Column(name="admission_id")
	private Long admissionId;

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

	@Column(name="number_of_days")
	private BigDecimal numberOfDays;

	@Column(name="patient_age")
	private BigDecimal patientAge;

	private String relation;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	@Column(name="tpa_name")
	private String tpaName;

	//bi-directional many-to-one association to DiseaseDetail
	@ManyToOne
	@JoinColumn(name="disease_id")
	private DiseaseDetail diseaseDetail;

	//bi-directional many-to-one association to HospitalDetail
	@ManyToOne
	@JoinColumn(name="hospital_id")
	private HospitalDetail hospitalDetail;

	//bi-directional many-to-one association to PackageDetail
	@ManyToOne
	@JoinColumn(name="package_id")
	private PackageDetail packageDetail;

	//bi-directional many-to-one association to PatientDetail
	@ManyToOne
	@JoinColumn(name="patient_id")
	private PatientDetail patientDetail;

	//bi-directional many-to-one association to ClaimDetail
	@OneToMany(mappedBy="admissionDetail")
	private List<ClaimDetail> claimDetails;

	public AdmissionDetail() {
	}

	public Long getAdmissionId() {
		return this.admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
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

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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

	public String getTpaName() {
		return this.tpaName;
	}

	public void setTpaName(String tpaName) {
		this.tpaName = tpaName;
	}

	public DiseaseDetail getDiseaseDetail() {
		return this.diseaseDetail;
	}

	public void setDiseaseDetail(DiseaseDetail diseaseDetail) {
		this.diseaseDetail = diseaseDetail;
	}

	public HospitalDetail getHospitalDetail() {
		return this.hospitalDetail;
	}

	public void setHospitalDetail(HospitalDetail hospitalDetail) {
		this.hospitalDetail = hospitalDetail;
	}

	public PackageDetail getPackageDetail() {
		return this.packageDetail;
	}

	public void setPackageDetail(PackageDetail packageDetail) {
		this.packageDetail = packageDetail;
	}

	public PatientDetail getPatientDetail() {
		return this.patientDetail;
	}

	public void setPatientDetail(PatientDetail patientDetail) {
		this.patientDetail = patientDetail;
	}

	public List<ClaimDetail> getClaimDetails() {
		return this.claimDetails;
	}

	public void setClaimDetails(List<ClaimDetail> claimDetails) {
		this.claimDetails = claimDetails;
	}

	public ClaimDetail addClaimDetail(ClaimDetail claimDetail) {
		getClaimDetails().add(claimDetail);
		claimDetail.setAdmissionDetail(this);

		return claimDetail;
	}

	public ClaimDetail removeClaimDetail(ClaimDetail claimDetail) {
		getClaimDetails().remove(claimDetail);
		claimDetail.setAdmissionDetail(null);

		return claimDetail;
	}

}