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
@Table(name="motor_details")
@NamedQuery(name="UploadDetail.findAll", query="SELECT u FROM UploadDetail u")
public class UploadDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UPLOAD_DETAILS_ID_GENERATOR", sequenceName="MOTOR_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UPLOAD_DETAILS_ID_GENERATOR")
	private Long id;

	private String csvfile;
	
	@Temporal(TemporalType.DATE)
	@Column(name="upload_date")
	private Date uploadDate;

	
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


	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	
}