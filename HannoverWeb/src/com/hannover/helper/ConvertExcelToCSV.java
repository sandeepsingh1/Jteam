package com.hannover.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hannover.constants.HannoverConstants;
import com.hannover.form.UploadFileForm;

public class ConvertExcelToCSV {
	private static String comma = ",";
	private static String blank = " ";
	public static List<String> convertXLSXToCSV(UploadFileForm uploadFileForm) {
		List<String> csvList = new ArrayList<String>();
		StringBuffer data = new StringBuffer();
		StringBuffer csvForAI = new StringBuffer();
		HannoverConstants constants = new HannoverConstants();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(uploadFileForm.getExcelFilePath().getInputStream());
	    	XSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			Cell cell;
			Iterator<Row> rowIterator = sheet.iterator();
			int cellIndex=0;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					cellIndex = cell.getColumnIndex();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						data.append(cell.getBooleanCellValue());
						data.append(comma);
						if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
							csvForAI.append(cell.getBooleanCellValue());
							csvForAI.append(comma);
						}
						break;
					case Cell.CELL_TYPE_NUMERIC:
						data.append(cell.getNumericCellValue());
						data.append(comma);
						if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
							csvForAI.append(cell.getNumericCellValue());
							csvForAI.append(comma);
						}
						break;
					case Cell.CELL_TYPE_STRING:
						data.append(getStringValue(cell));
						data.append(comma);
						if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
							csvForAI.append(getStringValue(cell));
							csvForAI.append(comma);
						}
						break;
					case Cell.CELL_TYPE_BLANK:
						data.append(comma);
						if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
							csvForAI.append(comma);
						}
						break;
					case Cell.CELL_TYPE_ERROR:
						data.append(cell.getErrorCellValue());
						data.append(comma);
						if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
							csvForAI.append(cell.getErrorCellValue());
							csvForAI.append(comma);
						}
						break;	
					case Cell.CELL_TYPE_FORMULA:
						switch (cell.getCachedFormulaResultType()){
                        case Cell.CELL_TYPE_STRING:
                        	data.append(getStringValue(cell));
                        	data.append(comma);
                        	if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
    							csvForAI.append(getStringValue(cell));
    							csvForAI.append(comma);
    						}
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                        	data.append(cell.getNumericCellValue());
                        	data.append(comma);
                        	if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
    							csvForAI.append(cell.getNumericCellValue());
    							csvForAI.append(comma);
    						}
                            break;
                        }
                        break;
					default:
						data.append(getStringValue(cell));
						data.append(comma);
						if(constants.hannoverHap.containsValue(String.valueOf(cellIndex))){
							csvForAI.append(getStringValue(cell));
							csvForAI.append(comma);
						}
					}
				}
				char indexOfComma = data.charAt(data.length()-1);
				if(indexOfComma == ','){
					data = data.replace(data.length()-1, data.length(), "");
				}
				indexOfComma = csvForAI.charAt(csvForAI.length()-1);
				if(indexOfComma == ','){
					csvForAI = csvForAI.replace(csvForAI.length()-1, csvForAI.length(), "");
				}
				data.append('\n'); 
				csvForAI.append('\n'); 
			}
		} catch (Exception e) {
			System.err.println("Exception :" + e.getMessage());
		}
		csvList.add(data.toString());
		csvList.add(csvForAI.toString());
		return csvList;
	}
	
    private static String getStringValue(Cell cell){
    	String str = cell.getStringCellValue();
    	str = str.trim();
    	str = str.replaceAll(comma, blank);
    	str = str.replaceAll("[\\t\\n\\r]",blank);
    	str = str.replace("Age Remarks(age as per card)", "Age");
    	str = str.replace("Gender Remarks(Gender as per card)", "Gender");
    	return str;
    }

}