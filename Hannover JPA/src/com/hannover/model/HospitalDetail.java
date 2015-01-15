package com.hannover.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hospital_details database table.
 * 
 */
@Entity
@Table(name="hospital_details")
@NamedQuery(name="HospitalDetail.findAll", query="SELECT h FROM HospitalDetail h")
public class HospitalDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HOSPITAL_DETAILS_HOSPITALID_GENERATOR", sequenceName="HOSPITAL_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOSPITAL_DETAILS_HOSPITALID_GENERATOR")
	@Column(name="hospital_id")
	private Long hospitalId;

	@Column(name="hospital_code")
	private String hospitalCode;

	@Column(name="hospital_district_name")
	private String hospitalDistrictName;

	@Column(name="hospital_name")
	private String hospitalName;

	@Column(name="hospital_type")
	private String hospitalType;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	//bi-directional many-to-one association to AdmissionDetail
	@OneToMany(mappedBy="hospitalDetail")
	private List<AdmissionDetail> admissionDetails;

	public HospitalDetail() {
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalCode() {
		return this.hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getHospitalDistrictName() {
		return this.hospitalDistrictName;
	}

	public void setHospitalDistrictName(String hospitalDistrictName) {
		this.hospitalDistrictName = hospitalDistrictName;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalType() {
		return this.hospitalType;
	}

	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
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

	public List<AdmissionDetail> getAdmissionDetails() {
		return this.admissionDetails;
	}

	public void setAdmissionDetails(List<AdmissionDetail> admissionDetails) {
		this.admissionDetails = admissionDetails;
	}

	public AdmissionDetail addAdmissionDetail(AdmissionDetail admissionDetail) {
		getAdmissionDetails().add(admissionDetail);
		admissionDetail.setHospitalDetail(this);

		return admissionDetail;
	}

	public AdmissionDetail removeAdmissionDetail(AdmissionDetail admissionDetail) {
		getAdmissionDetails().remove(admissionDetail);
		admissionDetail.setHospitalDetail(null);

		return admissionDetail;
	}

}