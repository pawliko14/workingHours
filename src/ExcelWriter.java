
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import POJO.data_object_afdeling;
import POJO.data_object_afdnr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelWriter {

	private static String[] columns = {"AFDNR", "NEST", "HOURS", "MINUTES"};   
	private static String[] columns_afdeling = {"afdeling", "Naam", "HOURS", "MINUTES"};   

    private List<data_object_afdnr> data_list_afdnr;
    private List<data_object_afdeling> data_list_afdeling;
    
    
   

    public ExcelWriter(List<data_object_afdnr> data_list_afdnr, List<data_object_afdeling> data_list_afdeling) {
    	this.data_list_afdnr = new ArrayList<>();
		this.data_list_afdnr = data_list_afdnr;
		
		this.data_list_afdeling = new ArrayList<>();
		this.data_list_afdeling = data_list_afdeling;
		
	}
    
    public void mergeCell(Sheet sheet)
    {
    	int firstRow = 1;
    	int lastRow = 1;
    	int firstCol = 0;
    	int lastCol = 3;
    	sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }
    
    private void firstDocument(Workbook workbook, int summary, String date_from, String date_to)
    {
        /* CreationHelper helps us create instances of various things like DataFormat, 
        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
     CreationHelper createHelper = workbook.getCreationHelper();

     Sheet sheet = workbook.createSheet("HoursByAfDNR");
    	
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

    	
        //create a Row with datatime
        Row dateTimeRow = sheet.createRow(1);
        Cell cell_datetime = dateTimeRow.createCell(0);
        
        mergeCell(sheet);
                
    	cell_datetime.setCellValue("Working hours between: " + date_from + " and " + date_to );
        
        Row headerRow = sheet.createRow(2);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        int rowNum = 3;
        for(data_object_afdnr obj: data_list_afdnr) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(obj.getafdnr());
            row.createCell(1).setCellValue(obj.getNest());

            Cell dateOfBirthCell = row.createCell(2);
            dateOfBirthCell.setCellValue(obj.gethours());
            dateOfBirthCell.setCellStyle(dateCellStyle);

            row.createCell(3).setCellValue(obj.getminutes());
        }
        // create Row for Summary
        Row row = sheet.createRow(rowNum++);
        Cell cell = row.createCell(0);
        	cell.setCellValue("hours summ:");
            cell.setCellStyle(headerCellStyle);

        Cell cell2 = row.createCell(1);
        	cell2.setCellValue(summary);
        	cell2.setCellStyle(headerCellStyle);

        
		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }
    
    
	private void SecondDocument(Workbook workbook, int summary, String date_from, String date_to) {
		
		   /* CreationHelper helps us create instances of various things like DataFormat, 
        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
     CreationHelper createHelper = workbook.getCreationHelper();

     	Sheet sheet = workbook.createSheet("HoursByAfdeling");
    	
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

    	
        //create a Row with datatime
        Row dateTimeRow = sheet.createRow(1);
        Cell cell_datetime = dateTimeRow.createCell(0);
        
        mergeCell(sheet);
                
    	cell_datetime.setCellValue("Working hours between: " + date_from + " and " + date_to );
        
        Row headerRow = sheet.createRow(2);

        for(int i = 0; i < columns_afdeling.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns_afdeling[i]);
            cell.setCellStyle(headerCellStyle);
        }

        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        int rowNum = 3;
        for(data_object_afdeling obj: data_list_afdeling) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(obj.getAfdeling());
            row.createCell(1).setCellValue(obj.getNaam());

            Cell dateOfBirthCell = row.createCell(2);
            dateOfBirthCell.setCellValue(obj.gethours());
            dateOfBirthCell.setCellStyle(dateCellStyle);

            row.createCell(3).setCellValue(obj.getminutes());
        }
        // create Row for Summary
        Row row = sheet.createRow(rowNum++);
        Cell cell = row.createCell(0);
        	cell.setCellValue("hours summ:");
            cell.setCellStyle(headerCellStyle);

        Cell cell2 = row.createCell(1);
        	cell2.setCellValue(summary);
        	cell2.setCellStyle(headerCellStyle);

        
		// Resize all columns to fit the content size
        for(int i = 0; i < columns_afdeling.length; i++) {
            sheet.autoSizeColumn(i);
        }
		
	}

    public void run_example(String path,int summary,String date_from, String date_to) throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        firstDocument(workbook,summary,date_from,date_to);
        SecondDocument(workbook,summary,date_from,date_to);

  


        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }


	
}
