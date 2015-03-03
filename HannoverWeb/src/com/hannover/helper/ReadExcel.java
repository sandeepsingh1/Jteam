package com.hannover.helper;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;

import com.hannover.form.UploadFileForm;
import com.hannover.model.PatientClaimDetail;
import com.hannover.model.UploadDetail;
import com.hannover.service.SaveExcelService;
import com.hannover.service.SaveExcelServiceImpl;


	public class ReadExcel {

    public static void uploadFile(InputStream file, UploadFileForm uploadFileForm) throws Exception {
            KnowledgeBase kbase = RunRules.readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			XSSFWorkbook workbook = new XSSFWorkbook(file);
	    	XSSFSheet sheet = workbook.getSheetAt(0);
	    	List<PatientClaimDetail> pcdList = new ArrayList<PatientClaimDetail>(100);
	    	PatientClaimDetail patientCliamDetail = null;
	    	UploadDetail uploadDetail = new UploadDetail();
	    	uploadDetail.setDescription(uploadFileForm.getDescription());
	    	uploadDetail.setState(uploadFileForm.getState());
	    	uploadDetail.setMonth(uploadFileForm.getMonth());
	    	uploadDetail.setYear(uploadFileForm.getYear());
	    	uploadDetail.setCsvfile(uploadFileForm.getOutputStream());
	    	uploadDetail.setCsvfileAi(uploadFileForm.getOutputStreamAi());
	    	SaveExcelService saveExcelService = new SaveExcelServiceImpl();
	    	uploadDetail = saveExcelService.uploadFileDetails(uploadDetail);
			Row row;
			Cell cell;
			int cellIndex=0;
			Iterator<Row> rowIterator = sheet.iterator();		
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
	    		if(row.getRowNum() !=0){
	    			if(pcdList.size() >= 100){
	    				System.out.println(" pcdList size = "+pcdList.size());
	    		    	saveExcelService.createPatientCliamDetails(pcdList);
	    		    	pcdList = null;
	    		    	pcdList = new ArrayList<PatientClaimDetail>(100);
	    			}
		    	    patientCliamDetail = new PatientClaimDetail();
		    	    patientCliamDetail.setUploadDetailsId(uploadDetail.getId());
		    		Iterator<Cell> cellIterator = row.cellIterator();
		    		while(cellIterator.hasNext()){
		    			cell = cellIterator.next();
		    			cellIndex = cell.getColumnIndex();
		    			if(cellIndex == 1){
		    				patientCliamDetail.setUrn(getStringValue(cell));
		    			}
		    			else if(cellIndex == 3){
		    				try{
		    					patientCliamDetail.setPatientAge(BigDecimal.valueOf(cell.getNumericCellValue()));
		    				}catch(Exception e){
		    					String val = cell.getStringCellValue();
		    					BigDecimal dVal = null;
		    					try{
		    						dVal = new BigDecimal(val);
		    					}catch(NumberFormatException ne){
		    						dVal = BigDecimal.valueOf(0);
		    					}
		    					patientCliamDetail.setPatientAge(dVal);
		    				}
		    			}
		    			else if(cellIndex == 5){
		    				patientCliamDetail.setPatientName(getStringValue(cell));
		    			}
		    			else if(cellIndex == 7){
		    				patientCliamDetail.setAdmissionDate(cell.getDateCellValue());
		    			}
		    			else if(cellIndex == 8){
		    				patientCliamDetail.setAdmissionTime(cell.getDateCellValue());
		    			}
		    			else if(cellIndex == 11){
		    				try{
			    				patientCliamDetail.setNumberOfDays(BigDecimal.valueOf(cell.getNumericCellValue()));
		    				}catch(Exception e){
		    					String val = cell.getStringCellValue();
		    					BigDecimal dVal = null;
		    					try{
		    						dVal = new BigDecimal(val);
		    					}catch(NumberFormatException ne){
		    						dVal = BigDecimal.valueOf(0);
		    					}
		    					patientCliamDetail.setNumberOfDays(dVal);
		    				}
		    			}
		    			else if(cellIndex == 16){
		    				patientCliamDetail.setHospitalName(getStringValue(cell));
		    			}
		    			else if(cellIndex == 21){
		    				patientCliamDetail.setDiseaseName(getStringValue(cell));
		    			}
		    			else if(cellIndex == 40){
		    				patientCliamDetail.setGender(getStringValue(cell));
		    			}
		    		}
		    		pcdList.add(patientCliamDetail);
		    		ksession.insert(patientCliamDetail);
	                ksession.fireAllRules();
	    			
		    	}
	    	}
	    	ksession.dispose(); 
	    	if(pcdList.size() >= 100){
		    	System.out.println(" pcdList size = "+pcdList.size());
		    	saveExcelService.createPatientCliamDetails(pcdList);
		    	pcdList = null;
	    	}
	    }
	    
	    private static String getStringValue(Cell cell){
	    	int cellType = cell.getCellType();
	    	if(cellType == Cell.CELL_TYPE_STRING){
	    		return cell.getStringCellValue();
	    	}else{
	    		return "";
	    	}
	    }
}

