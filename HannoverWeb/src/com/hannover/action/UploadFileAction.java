package com.hannover.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.hannover.form.UploadFileForm;
import com.hannover.helper.ConvertExcelToCSV;
import com.hannover.helper.ReadExcel;
import com.hannover.model.UploadDetail;
import com.hannover.service.SaveExcelService;
import com.hannover.service.SaveExcelServiceImpl;


public class UploadFileAction extends DispatchAction {

	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("success");
	}
	
	public ActionForward uploadExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		FormFile excelFile = uploadFileForm.getExcelFilePath();
		uploadFileForm.setOutputStream(ConvertExcelToCSV.convertXLSXToCSV(uploadFileForm));
		ReadExcel.uploadFile(excelFile.getInputStream(), uploadFileForm);
		uploadFileForm.setState(uploadFileForm.getState());
		uploadFileForm.setYear(uploadFileForm.getYear());
		uploadFileForm.setMonth(uploadFileForm.getMonth());
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
		if(uploadFileForm.getState() != null && uploadFileForm.getYear() != null && uploadFileForm.getMonth() != null){
			SaveExcelService saveExcelService = new SaveExcelServiceImpl();
			UploadDetail uploadDetail = saveExcelService.getUploadData(uploadFileForm.getState(), uploadFileForm.getYear(), uploadFileForm.getMonth());
			if(uploadDetail!= null){
				String pieData = "Trends Status~~~"+uploadFileForm.getState()+" for "+uploadFileForm.getMonth()+" "+uploadFileForm.getYear()+"~~~\n"+
						saveExcelService.getPieData(uploadDetail.getId());
				uploadFileForm.setPieData(pieData);
			}
		}
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
		return mapping.findForward("showTriggerPivot");
	}
	
	public ActionForward loadPivotData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		uploadFileForm.setState(uploadFileForm.getState());
		uploadFileForm.setYear(uploadFileForm.getYear());
		uploadFileForm.setMonth(uploadFileForm.getMonth());
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setOutputStream(saveExcelService.getCSVFileData(uploadFileForm.getState(), uploadFileForm.getYear(), uploadFileForm.getMonth()));
		return mapping.findForward("showTriggerPivot");
	}

}
