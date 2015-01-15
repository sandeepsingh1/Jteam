package com.hannover.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.hannover.bean.State;
import com.hannover.model.PatientCliamDetail;

public class UploadFileForm extends ActionForm{
	
	private static final long serialVersionUID = -473562596852452021L;
	private FormFile excelFilePath;
	private List<State> stateList = new ArrayList<State>();
	private List<PatientCliamDetail> pcdList = new ArrayList<PatientCliamDetail>();
	private String stateSelected;
	private String outputStream;
	
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
	public List<PatientCliamDetail> getPcdList() {
		return pcdList;
	}
	public void setPcdList(List<PatientCliamDetail> pcdList) {
		this.pcdList = pcdList;
	}
	public String getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(String outputStream) {
		this.outputStream = outputStream;
	}
	
}
