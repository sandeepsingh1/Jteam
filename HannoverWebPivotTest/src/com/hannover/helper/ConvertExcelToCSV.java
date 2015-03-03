package com.hannover.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hannover.form.UploadFileForm;

public class ConvertExcelToCSV {
	private static String comma = ",";
	private static String blank = " ";
	public static void convertXLSXToCSV(UploadFileForm uploadFileForm) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("e:\\Hannover\\temp.csv"), true)));
			System.out.println(uploadFileForm.getExcelFilePath().getFileName());
			File inputFile = new File("E:\\Hannover\\MOTOR CLAIMS  PAID 12-13.xlsx");
			OPCPackage oPackage = OPCPackage.open(inputFile);
			XSSFWorkbook workbook = new XSSFWorkbook(oPackage);
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
						writer.print(cell.getBooleanCellValue());
						writer.print(comma);
						break;
					case Cell.CELL_TYPE_NUMERIC:
						writer.print(cell.getNumericCellValue());
						writer.print(comma);
						break;
					case Cell.CELL_TYPE_STRING:
						writer.print(getStringValue(cell));
						writer.print(comma);
						break;
					case Cell.CELL_TYPE_BLANK:
						writer.print(comma);
						break;
					case Cell.CELL_TYPE_ERROR:
						writer.print(cell.getErrorCellValue());
						writer.print(comma);
						break;	
					case Cell.CELL_TYPE_FORMULA:
						switch (cell.getCachedFormulaResultType()){
                        case Cell.CELL_TYPE_STRING:
                        	writer.print(getStringValue(cell));
                        	writer.print(comma);
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                        	writer.print(cell.getNumericCellValue());
                        	writer.print(comma);
                            break;
                        }
                        break;
					default:
						writer.print(getStringValue(cell));
						writer.print(comma);
					}
				}
//				char indexOfComma = data.charAt(data.length()-1);
//				if(indexOfComma == ','){
//					data = data.replace(data.length()-1, data.length(), "");
//				}
				writer.print('\n'); 
			}
		} catch (Exception e) {
			System.err.println("Exception :" + e.getMessage());
		}
		writer.close ();  
		//System.out.println(data);
		//return data.toString();
	}
	
    private static String getStringValue(Cell cell){
//    	StringBuffer str = new StringBuffer(cell.getStringCellValue());
//    	str.trimToSize();
//    	str.replaceAll(comma, blank);
//        str.replaceAll("[\\t\\n\\r]",blank);
//    	str.replace("Age Remarks(age as per card)", "Age");
//    	str = str.replace("Gender Remarks(Gender as per card)", "Gender");
//    	return str;
    	return cell.getStringCellValue();
    }

}