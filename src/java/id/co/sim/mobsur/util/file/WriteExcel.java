/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @created Jan 26, 2017
 * @author awal
 */
public class WriteExcel {

  private final File file;
  private final List<String> titles;
  private final List<String> headers;
  private final List<List<String>> contents;
  private final String sheetName;
  
  public WriteExcel(File file, List<String> titles, List<String> headers, List<List<String>> contents, String sheetName) {
    this.file = file;
    this.titles = titles;
    this.headers = headers;
    this.contents = contents;
    this.sheetName = sheetName;
  }
  
  public void createFile() throws IOException {
    //be aware this is a new java 7 feature, avoid the object have not closed after execute
    try ( Workbook workbook = new HSSFWorkbook() ) { //.xls extention
      Sheet sheet = workbook.createSheet(sheetName);
      Row row;
      Cell cell;
      CellStyle cellStyle = workbook.createCellStyle();
      Font font = workbook.createFont();
      font.setBoldweight(Font.BOLDWEIGHT_BOLD);
      cellStyle.setFont(font);
      //variable
      int rowIdx = 0;
      int cellIdx = 0;
      
      // add title
      for (String title : titles) {
        row = sheet.createRow(rowIdx++);
        cell = row.createCell(0);
        cell.setCellValue(title);
        cell.setCellStyle(cellStyle);
      }
      
      // add header
      rowIdx++;
      row = sheet.createRow(rowIdx++);
      for(String header : headers) {
        cell = row.createCell(cellIdx++);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(header);
      }
      
      // add detail
      for (List<String> content : contents) {
        cellIdx = 0;
        row = sheet.createRow(rowIdx++);
        for(String str : content) {
          cell = row.createCell(cellIdx++);
          cell.setCellValue(str);
        }
      }
      for(int colIdx = 1; colIdx < cellIdx; colIdx++)
        sheet.autoSizeColumn(colIdx);
      
      //be aware this is a new java 7 feature, avoid the object have not closed after execute
      try (OutputStream outFile = new FileOutputStream(file)) {
        workbook.write(outFile);
      }
    }
  }
}
