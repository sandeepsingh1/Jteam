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
 * The persistent class for the disease_details database table.
 * 
 */
@Entity
@Table(name="disease_details")
@NamedQuery(name="DiseaseDetail.findAll", query="SELECT d FROM DiseaseDetail d")
public class DiseaseDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DISEASE_DETAILS_DISEASEID_GENERATOR", sequenceName="DISEASE_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DISEASE_DETAILS_DISEASEID_GENERATOR")
	@Column(name="disease_id")
	private Long id;

	@Column(name="disease_name")
	private String diseaseName;

	@Column(name="disease_type")
	private String diseaseType;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	//bi-directional many-to-one association to AdmissionDetail
	@OneToMany(mappedBy="diseaseDetail")
	private List<AdmissionDetail> admissionDetails;

	public DiseaseDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long diseaseId) {
		this.id = diseaseId;
	}

	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseType() {
		return this.diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
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
		admissionDetail.setDiseaseDetail(this);

		return admissionDetail;
	}

	public AdmissionDetail removeAdmissionDetail(AdmissionDetail admissionDetail) {
		getAdmissionDetails().remove(admissionDetail);
		admissionDetail.setDiseaseDetail(null);

		return admissionDetail;
	}

}