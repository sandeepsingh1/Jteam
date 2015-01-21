package com.hannover.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.hannover.bean.State;
import com.hannover.model.PatientClaimDetail;

public class UploadFileForm extends ActionForm{
	
	private static final long serialVersionUID = -473562596852452021L;
	private FormFile excelFilePath;
	private List<State> stateList = new ArrayList<State>();
	private List<PatientClaimDetail> pcdList = new ArrayList<PatientClaimDetail>();
	private String stateSelected;
	private String outputStream;
	private String pieData;
	private String state;
	private String month;
	private String year;
	private String description;
	
	public FormFile getExcelFilePath() {
		return excelFilePath;
	}
	public void setExcelFilePath(FormFile excelFilePath) {
		this.excelFilePath = excelFilePath;
	}
	public List<State> getStateList() {
		return stateList;
	}
	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
	public String getStateSelected() {
		return stateSelected;
	}
	public void setStateSelected(String stateSelected) {
		this.stateSelected = stateSelected;
	}
	public List<PatientClaimDetail> getPcdList() {
		return pcdList;
	}
	public void setPcdList(List<PatientClaimDetail> pcdList) {
		this.pcdList = pcdList;
	}
	public String getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(String outputStream) {
		this.outputStream = outputStream;
	}
	public String getPieData() {
		return pieData;
	}
	public void setPieData(String pieData) {
		this.pieData = pieData;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
