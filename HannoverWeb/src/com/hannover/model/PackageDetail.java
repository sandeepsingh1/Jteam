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
 * The persistent class for the package_details database table.
 * 
 */
@Entity
@Table(name="package_details")
@NamedQuery(name="PackageDetail.findAll", query="SELECT p FROM PackageDetail p")
public class PackageDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PACKAGE_DETAILS_PACKAGEID_GENERATOR", sequenceName="PACKAGE_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACKAGE_DETAILS_PACKAGEID_GENERATOR")
	@Column(name="package_id")
	private Long id;

	@Column(name="package_code")
	private String packageCode;

	@Column(name="package_name")
	private String packageName;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	//bi-directional many-to-one association to AdmissionDetail
	@OneToMany(mappedBy="packageDetail")
	private List<AdmissionDetail> admissionDetails;

	public PackageDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long packageId) {
		this.id = packageId;
	}

	public String getPackageCode() {
		return this.packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
		admissionDetail.setPackageDetail(this);

		return admissionDetail;
	}

	public AdmissionDetail removeAdmissionDetail(AdmissionDetail admissionDetail) {
		getAdmissionDetails().remove(admissionDetail);
		admissionDetail.setPackageDetail(null);

		return admissionDetail;
	}

}