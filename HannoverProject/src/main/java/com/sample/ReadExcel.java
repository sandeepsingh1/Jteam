package com.sample;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;


	public class ReadExcel {

	    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
            KnowledgeBase kbase = RunRules.readKnowledgeBase();
            List<String> list = new ArrayList<String>( );
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            ksession.setGlobal("list", list);
            //KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
	    	FileInputStream file = new FileInputStream(new File("sample1.xlsx"));
	    	//Get the workbook instance for XLS file 
	    	XSSFWorkbook workbook = new XSSFWorkbook(file);
	    	//Get first sheet from the workbook
	    	XSSFSheet sheet = workbook.getSheetAt(0);
	    	//Get iterator to all the rows in current sheet
	    	for(Row row: sheet){
	    		if(row.getRowNum() !=0){
		    		AdmissionDetails ad = new AdmissionDetails();
		    		Calendar admissionTS = Calendar.getInstance();
		    		Calendar dischargeTS = Calendar.getInstance();
		    		Iterator<Cell> cellIterator = row.cellIterator();
		    		while(cellIterator.hasNext()){
		    			Cell cell = cellIterator.next();
		    			int cellIndex = cell.getColumnIndex();
		    			//System.out.println(cellIndex);
		    			if(cellIndex == 1){
		    				ad.setUrn(cell.getStringCellValue());
		    			}
		    			if(cellIndex == 5){
		    				ad.setPatientName(cell.getStringCellValue());
		    			}
		    			if(cellIndex == 21){
		    				ad.setDiseaseName(cell.getStringCellValue());
		    			}
		    			if(cellIndex == 11){
		    				try{
		    					ad.setDuration(Double.valueOf(cell.getNumericCellValue()).intValue());
		    				}catch(Exception e){
		    					ad.setDuration(0);
		    				}
		    			}
		    		}

	                ksession.insert(ad);
	                ksession.fireAllRules();
		    	}
	    	}
	    	list = (List<String>) ksession.getGlobal("list");
    		System.out.println(list.size());
    		for(String failedRule: list){
    			System.out.println(failedRule);
    		}
	    	ksession.dispose(); 
	    }
}

