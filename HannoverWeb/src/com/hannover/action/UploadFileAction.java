package com.hannover.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.hannover.constants.HannoverConstants;
import com.hannover.form.UploadFileForm;
import com.hannover.helper.ConvertExcelToCSV;
import com.hannover.helper.ReadExcel;
import com.hannover.model.Trends;
import com.hannover.model.UploadDetail;
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
		FormFile excelFile = uploadFileForm.getExcelFilePath();
		List<String> csvList = ConvertExcelToCSV.convertXLSXToCSV(uploadFileForm);
		if(csvList != null && csvList.size() > 1){
			uploadFileForm.setOutputStream(csvList.get(0));
			uploadFileForm.setOutputStreamAi(csvList.get(1));
		}
		ReadExcel.uploadFile(excelFile.getInputStream(), uploadFileForm);
		uploadFileForm.setState(uploadFileForm.getState());
		uploadFileForm.setYear(uploadFileForm.getYear());
		uploadFileForm.setMonth(uploadFileForm.getMonth());
		uploadFileForm.setShowPage("showTriggerPivot");
		return mapping.findForward("showTriggerPivot");
	}
	
	public ActionForward showTable(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setPcdList(saveExcelService.getFailedTrends());
		UploadDetail uploadDetail = saveExcelService.getLatestUploadData();
		uploadFileForm.setState(uploadDetail.getState());
		uploadFileForm.setYear(uploadDetail.getYear());
		uploadFileForm.setMonth(uploadDetail.getMonth());
		uploadFileForm.setShowPage("showTable");
		return mapping.findForward("showTable");
	}
	
	public ActionForward showReport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		if(uploadFileForm.getState() != null && uploadFileForm.getYear() != null && uploadFileForm.getMonth() != null){
			UploadDetail uploadDetail = saveExcelService.getUploadData(uploadFileForm.getState(), uploadFileForm.getYear(), uploadFileForm.getMonth());
			if(uploadDetail!= null){
				String pieData = "Trends Status~~~"+uploadDetail.getState()+" for "+uploadDetail.getMonth()+" "+uploadDetail.getYear()+"~~~\n"+
						saveExcelService.getPieData(uploadDetail.getId());
				uploadFileForm.setPieData(pieData);
			}
		}
		else{
			UploadDetail uploadDetail = saveExcelService.getLatestUploadData();
			if(uploadDetail!= null){
				String pieData = "Trends Status~~~"+uploadDetail.getState()+" for "+uploadDetail.getMonth()+" "+uploadDetail.getYear()+"~~~\n"+
						saveExcelService.getPieData(uploadDetail.getId());
				uploadFileForm.setPieData(pieData);
			}
		}
		uploadFileForm.setShowPage("showReport");
		return mapping.findForward("showReport");
	}
	
	public ActionForward getReportData(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setPcdList(saveExcelService.getFailedTrends());
		return null;
	}
	
	public ActionForward showTrigger(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setPcdList(saveExcelService.getFailedTrends());
		uploadFileForm.setShowPage("showTrigger");
		return mapping.findForward("showTrigger");
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
	
	public ActionForward showTriggerPivotAi(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		String csvAi = saveExcelService.getCSVAIData();
		if(csvAi != null){
			csvAi = csvAi.replaceAll("&quot;", "");
			csvAi = csvAi.replaceAll("\"", "");
		}
		uploadFileForm.setOutputStream(csvAi);
		HannoverConstants constants = new HannoverConstants();
		uploadFileForm.setAiColsList(constants.AI_COLUMNS);
		uploadFileForm.setShowPage("showTriggerPivotAi");
		return mapping.findForward("showTriggerPivotAi");
	}
	
	public ActionForward loadPivotData(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		uploadFileForm.setState(uploadFileForm.getState());
		uploadFileForm.setYear(uploadFileForm.getYear());
		uploadFileForm.setMonth(uploadFileForm.getMonth());
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setOutputStream(saveExcelService.getCSVFileData(uploadFileForm.getState(), uploadFileForm.getYear(), uploadFileForm.getMonth()));
		uploadFileForm.setShowPage("showTriggerPivot");
		return mapping.findForward("showTriggerPivot");
	}
	// ROW_NUM_FIRST  ROW_LABEL  COL_NUMS  ROW_NUMS
	public ActionForward saveAsTrend(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		String currentRows = request.getParameter("currentRows");
		String currentCols = request.getParameter("currentCols");
		String wpt = getWPTData(currentRows, currentCols);
		uploadFileForm.setWpt(wpt);
		Trends trend = new Trends();
		trend.setColumns(currentCols);
		trend.setRows(currentRows);
		trend.setTrendName("Trend "+System.currentTimeMillis());
		trend.setWptFile(wpt);
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		saveExcelService.saveTrend(trend);
		return showTriggerPivot(mapping, form, request, response);
	}
	
	public ActionForward showTrend(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadFileForm uploadFileForm = (UploadFileForm) form;
		String id = request.getParameter("id");
		SaveExcelService saveExcelService = new SaveExcelServiceImpl();
		uploadFileForm.setWpt(saveExcelService.getTrend(Long.parseLong(id)).getWptFile());
		return showTriggerPivot(mapping, form, request, response);
	}
	private String getWPTData(String currentRows, String currentCols){
		HannoverConstants constants = new HannoverConstants();
		String ROW_NUMS = "";
		String ROW_NUM_FIRST = "";
		String ROW_LABEL = "";
		String COL_NUMS = "";
		int count = 0;
		if(currentRows != null && !currentRows.equals("")){
			String[] rowsTemp = currentRows.split(",");
		    for (String row : rowsTemp){
		    	if(count != 0){
		    		ROW_NUMS = ROW_NUMS +",";
		    	} else{
		    		ROW_NUM_FIRST = constants.hannoverHap.get(row);
		    		ROW_LABEL = row;
		    	}
		    	ROW_NUMS = ROW_NUMS + constants.hannoverHap.get(row);
		    	count ++;
		    }
		}
	    if(currentCols != null && !currentCols.equals("")){
	    	count = 0;
		    String[] colsTemp = currentCols.split(",");
		    for (String col : colsTemp){
		    	if(count != 0){
		    		COL_NUMS = COL_NUMS +",";
		    	}
		    	COL_NUMS = COL_NUMS + constants.hannoverHap.get(col);
		    	count ++;
		    }
	    }
		String wpt = constants.WPT_TEMPLATE;
		wpt = wpt.replace("ROW_NUMS", ROW_NUMS);
		wpt = wpt.replace("COL_NUMS", COL_NUMS);
		wpt = wpt.replace("ROW_NUM_FIRST", ROW_NUM_FIRST);
		wpt = wpt.replace("ROW_LABEL", ROW_LABEL);
		return wpt;
	}

}
