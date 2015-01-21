package com.hannover.helper;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hannover.form.UploadFileForm;

public class ConvertExcelToCSV {

	public static String convertXLSXToCSV(UploadFileForm uploadFileForm) {
		StringBuffer data = new StringBuffer();
		String comma = ",";
		String blank = " ";
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(uploadFileForm.getExcelFilePath().getInputStream());
	    	XSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			Cell cell;
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						data.append(cell.getBooleanCellValue());
						data.append(comma);
						break;
					case Cell.CELL_TYPE_NUMERIC:
						data.append(cell.getNumericCellValue());
						data.append(comma);
						break;
					case Cell.CELL_TYPE_STRING:
						data.append(cell.getStringCellValue().replaceAll(comma, blank).replaceAll("[\\t\\n\\r]",blank));
						data.append(comma);
						break;
					case Cell.CELL_TYPE_BLANK:
						data.append(comma);
						break;
					case Cell.CELL_TYPE_ERROR:
						data.append(cell.getErrorCellValue());
						data.append(comma);
						break;	
					case Cell.CELL_TYPE_FORMULA:
						switch (cell.getCachedFormulaResultType()){
                        case Cell.CELL_TYPE_STRING:
                        	data.append(cell.getStringCellValue().replaceAll(comma, blank).replaceAll("[\\t\\n\\r]",blank));
                        	data.append(comma);
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                        	data.append(cell.getNumericCellValue());
                        	data.append(comma);
                            break;
                        }
                        break;
					default:
						data.append(cell.getStringCellValue().replaceAll(comma, blank).replaceAll("[\\t\\n\\r]",blank));
						cell.getStringCellValue();
					}
				}
				data.append('\n'); 
			}
		} catch (Exception e) {
			System.err.println("Exception :" + e.getMessage());
		}
		return data.toString();
	}

}