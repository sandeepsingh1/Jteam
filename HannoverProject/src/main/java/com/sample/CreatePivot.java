package com.sample;
import java.io.FileOutputStream;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;
public class CreatePivot {  
        public static void main(String[] args) throws Exception{
                /* Read the input file that contains the data to pivot */
                FileInputStream input_document = new FileInputStream(new File("sample1 Pivot.xlsx"));    
                /* Create a POI XSSFWorkbook Object from the input file */
                XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document); 
                /* Read Data to be Pivoted - we have only one worksheet */
                XSSFSheet sheet = my_xlsx_workbook.getSheetAt(0); 
                XSSFSheet sheet2 = my_xlsx_workbook.createSheet(); 
                /* Get the reference for Pivot Data */
                AreaReference a =new AreaReference("Y1:AO10381");
      
                /* Find out where the Pivot Table needs to be placed */
                CellReference b=new CellReference("C5");
                /* Create Pivot Table */
                XSSFPivotTable pivotTable = sheet2.createPivotTable(a,b,sheet);
                /* Add filters */
                pivotTable.addReportFilter(0);
                pivotTable.addRowLabel(16);
                pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, 2); 
                /* Write Pivot Table to File */
                FileOutputStream output_file = new FileOutputStream(new File("pivot1.xlsx")); 
                my_xlsx_workbook.write(output_file);
                input_document.close(); 
        }
}