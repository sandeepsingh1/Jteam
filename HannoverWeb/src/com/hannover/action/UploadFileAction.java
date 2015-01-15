package com.hannover.action;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.hannover.bean.State;
import com.hannover.form.UploadFileForm;
import com.hannover.helper.ConvertExcelToCSV;
import com.hannover.helper.ReadExcel;
import com.hannover.service.SaveExcelService;
import com.hannover.service.SaveExcelServiceImpl;


public class UploadFileAction extends DispatchAction {

	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		State state= new State();
		List<State> list = new ArrayList<State>();
		state.setId(1);
		state.setName("Haryana");
		list.add(state);
		state.setId(2);
		state.setName("Delhi");
		list.add(state);
		uploadFileForm.setStateList(list);
		
		return mapping.findForward("success");
	}
	
	public ActionForward uploadExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		FormFile excelFile = uploadFileForm.getExcelFilePath();
		InputStream file = excelFile.getInputStream();
		ReadExcel.uploadFile(file);
		uploadFileForm.setOutputStream(ConvertExcelToCSV.convertXLSXToCSV(excelFile.getInputStream()));
		return mapping.findForward("showTriggerPivot");
	}
	
	public ActionForward showTable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setPcdList(saveExcelService.getFailedTrends());
		return mapping.findForward("showTable");
	}
	
	public ActionForward showReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		return mapping.findForward("showReport");
	}
	
	public ActionForward getReportData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setPcdList(saveExcelService.getFailedTrends());
		return null;
	}
	
	public ActionForward showTrigger(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("showTrigger");
	}
	
	public ActionForward showTriggerPivot(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		FormFile excelFile = uploadFileForm.getExcelFilePath();
		InputStream file = excelFile.getInputStream();
		ReadExcel.uploadFile(file);
		return mapping.findForward("showTriggerPivot");
	}

}
