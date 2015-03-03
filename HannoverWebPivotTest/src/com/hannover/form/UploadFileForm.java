package com.hannover.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class UploadFileForm extends ActionForm{
	
	private static final long serialVersionUID = -473562596852452021L;
	private FormFile excelFilePath;
	//private List<State> stateList = new ArrayList<State>();
	//private List<PatientClaimDetail> pcdList = new ArrayList<PatientClaimDetail>();
	//private String stateSelected;
	private String outputStream;
	//private String outputStreamAi;
	//private String pieData;
	/*private String state;
	private String month;
	private String year;
	private String description;*/
	private String showPage;
	
	public String getShowPage() {
		return showPage;
	}
	public void setShowPage(String showPage) {
		this.showPage = showPage;
	}
	public FormFile getExcelFilePath() {
		return excelFilePath;
	}
	public void setExcelFilePath(FormFile excelFilePath) {
		this.excelFilePath = excelFilePath;
	}
	
	public String getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(String outputStream) {
		this.outputStream = outputStream;
	}
	
}
