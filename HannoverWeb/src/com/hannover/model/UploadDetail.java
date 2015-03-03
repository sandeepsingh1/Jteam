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
 * The persistent class for the upload_details database table.
 * 
 */
@Entity
@Table(name="upload_details")
@NamedQuery(name="UploadDetail.findAll", query="SELECT u FROM UploadDetail u")
public class UploadDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UPLOAD_DETAILS_ID_GENERATOR", sequenceName="UPLOAD_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UPLOAD_DETAILS_ID_GENERATOR")
	private Long id;

	private String csvfile;
	
	private String csvfileAi;

	public String getCsvfileAi() {
		return csvfileAi;
	}

	public void setCsvfileAi(String csvfileAi) {
		this.csvfileAi = csvfileAi;
	}

	private String description;

	private String month;

	@Column(name="number_of_failed_records")
	private BigDecimal numberOfFailedRecords;

	@Column(name="number_of_records")
	private BigDecimal numberOfRecords;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	private String state;

	@Temporal(TemporalType.DATE)
	@Column(name="upload_date")
	private Date uploadDate;

	private String year;


	public UploadDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCsvfile() {
		return this.csvfile;
	}

	public void setCsvfile(String csvfile) {
		this.csvfile = csvfile;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public BigDecimal getNumberOfFailedRecords() {
		return this.numberOfFailedRecords;
	}

	public void setNumberOfFailedRecords(BigDecimal numberOfFailedRecords) {
		this.numberOfFailedRecords = numberOfFailedRecords;
	}

	public BigDecimal getNumberOfRecords() {
		return this.numberOfRecords;
	}

	public void setNumberOfRecords(BigDecimal numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}