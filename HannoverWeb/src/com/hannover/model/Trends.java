package com.hannover.model;

import java.io.Serializable;
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
 * The persistent class for the trends database table.
 * 
 */
@Entity
@Table(name="trends")
@NamedQuery(name="Trends.findAll", query="SELECT t FROM Trends t")
public class Trends extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRENDS_ID_GENERATOR", sequenceName="TRENDS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRENDS_ID_GENERATOR")
	@Column(name="id")
	private Long id;

	@Column(name="trend_name")
	private String trendName;

	@Column(name="rows")
	private String rows;
	
	@Column(name="wptfile")
	private String wptFile ;
	
	@Column(name="columns")
	private String columns;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	public Date createDate;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	public Trends() {
	}
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTrendName() {
		return trendName;
	}

	public void setTrendName(String trendName) {
		this.trendName = trendName;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getWptFile() {
		return wptFile;
	}

	public void setWptFile(String wptFile) {
		this.wptFile = wptFile;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRfu1() {
		return rfu1;
	}

	public void setRfu1(String rfu1) {
		this.rfu1 = rfu1;
	}

	public String getRfu2() {
		return rfu2;
	}

	public void setRfu2(String rfu2) {
		this.rfu2 = rfu2;
	}

	public String getRfu3() {
		return rfu3;
	}

	public void setRfu3(String rfu3) {
		this.rfu3 = rfu3;
	}

	public void setId(Long id) {
		this.id = id;
	}

}