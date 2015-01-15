package com.hannover.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the patient_details database table.
 * 
 */
@Entity
@Table(name="patient_details")
@NamedQuery(name="PatientDetail.findAll", query="SELECT p FROM PatientDetail p")
public class PatientDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PATIENT_DETAILS_PATIENTID_GENERATOR", sequenceName="PATIENT_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_DETAILS_PATIENTID_GENERATOR")
	@Column(name="patient_id")
	private Long id;

	@Column(name="beneficiary_block_name")
	private String beneficiaryBlockName;

	@Column(name="beneficiary_district_name")
	private String beneficiaryDistrictName;

	@Column(name="beneficiary_panchayat_name")
	private String beneficiaryPanchayatName;

	@Column(name="beneficiary_village_name")
	private String beneficiaryVillageName;

	private String gender;

	@Column(name="hof_name")
	private String hofName;

	@Column(name="member_id")
	private String memberId;

	@Column(name="patient_name")
	private String patientName;

	private String remarks;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	private String urn;

	//bi-directional many-to-one association to AdmissionDetail
	@OneToMany(mappedBy="patientDetail")
	private List<AdmissionDetail> admissionDetails;

	public PatientDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long patientId) {
		this.id = patientId;
	}

	public String getBeneficiaryBlockName() {
		return this.beneficiaryBlockName;
	}

	public void setBeneficiaryBlockName(String beneficiaryBlockName) {
		this.beneficiaryBlockName = beneficiaryBlockName;
	}

	public String getBeneficiaryDistrictName() {
		return this.beneficiaryDistrictName;
	}

	public void setBeneficiaryDistrictName(String beneficiaryDistrictName) {
		this.beneficiaryDistrictName = beneficiaryDistrictName;
	}

	public String getBeneficiaryPanchayatName() {
		return this.beneficiaryPanchayatName;
	}

	public void setBeneficiaryPanchayatName(String beneficiaryPanchayatName) {
		this.beneficiaryPanchayatName = beneficiaryPanchayatName;
	}

	public String getBeneficiaryVillageName() {
		return this.beneficiaryVillageName;
	}

	public void setBeneficiaryVillageName(String beneficiaryVillageName) {
		this.beneficiaryVillageName = beneficiaryVillageName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHofName() {
		return this.hofName;
	}

	public void setHofName(String hofName) {
		this.hofName = hofName;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getUrn() {
		return this.urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public List<AdmissionDetail> getAdmissionDetails() {
		return this.admissionDetails;
	}

	public void setAdmissionDetails(List<AdmissionDetail> admissionDetails) {
		this.admissionDetails = admissionDetails;
	}

	public AdmissionDetail addAdmissionDetail(AdmissionDetail admissionDetail) {
		getAdmissionDetails().add(admissionDetail);
		admissionDetail.setPatientDetail(this);

		return admissionDetail;
	}

	public AdmissionDetail removeAdmissionDetail(AdmissionDetail admissionDetail) {
		getAdmissionDetails().remove(admissionDetail);
		admissionDetail.setPatientDetail(null);

		return admissionDetail;
	}

}