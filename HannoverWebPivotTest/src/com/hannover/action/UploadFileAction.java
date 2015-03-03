package com.hannover.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hannover.form.UploadFileForm;
import com.hannover.helper.ToCSV;
import com.hannover.service.SaveExcelService;
import com.hannover.service.SaveExcelServiceImpl;


public class UploadFileAction extends DispatchAction {

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)	throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		uploadFileForm.setShowPage("uploadFile");
		return mapping.findForward("success");
	}
	
	public ActionForward uploadExcel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		//ConvertExcelToCSV.convertXLSXToCSV(uploadFileForm);
		ToCSV converter = new ToCSV();
		converter.convertFile("E:\\Hannover\\MOTOR CLAIMS  PAID 12-13.xlsx", "e:\\Hannover\\");
		
		uploadFileForm.setShowPage("showTriggerPivot");
		return mapping.findForward("showTriggerPivot");
	}
	
	
		
	public ActionForward showTriggerPivot(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		String csvBi = saveExcelService.getCSVBIData();
		if(csvBi != null){
			csvBi = csvBi.replaceAll("&quot;", "");
			csvBi = csvBi.replaceAll("\"", "");
		}
		uploadFileForm.setOutputStream(csvBi);
		uploadFileForm.setShowPage("showTriggerPivot");
		return mapping.findForward("showTriggerPivot");
	}
	
	
	

}
