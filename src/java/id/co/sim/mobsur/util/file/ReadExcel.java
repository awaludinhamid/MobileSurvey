/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util.file;

import id.co.sim.mobsur.util.DataConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @created Jan 25, 2017
 * @author awal
 */
public class ReadExcel {

  private final MultipartFile file;
  private final List<String> fields;
  private final boolean hasHeader;
  private final String fileName;
  
  public ReadExcel(MultipartFile file, List<String> fields, boolean hasHeader, String fileName) {
    this.file = file;
    this.fields = fields;
    this.hasHeader = hasHeader;
    this.fileName = fileName;
  }
  
  public List<Map<String,String>> getFileContents() throws IOException {
    //we worked on this highest object parent
    Workbook wb;
    //container
    List<Map<String,String>> values = new ArrayList();
    //separate excels 2003 and current
    if(fileName.contains(".xlsx"))//.xlsx
      wb = new XSSFWorkbook(file.getInputStream());
    else//.xls
      wb = new HSSFWorkbook(file.getInputStream());
    //get first sheet only, multi sheet not supported yet
    Sheet sheet = wb.getSheetAt(0);
    //file has header, remove first row
    if(hasHeader)
      sheet.removeRow(sheet.getRow(0));
    //the length of column
    int numOfColumn = fields.size();
    //convert data into string
    DataConverter dc = new DataConverter();
    //iterate over row
    for(Row row : sheet) {
      if(row != null) {
        Map<String,String> value = new HashMap();
        //iterate over column (base on fields content)
        for(int colIdx = 0; colIdx < numOfColumn; colIdx++) {
          Cell cell = row.getCell(colIdx);
          if(cell != null) {
            switch(cell.getCellType()) {
              case Cell.CELL_TYPE_STRING:
                //value.put(fields.get(colIdx), cell.getRichStringCellValue().getString());
                dc.setConverter(cell.getRichStringCellValue().getString());
                break;
              case Cell.CELL_TYPE_NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                  dc.setConverter(cell.getDateCellValue(), "dd-MMM-yy");
                  /*java.util.Date utilDate = cell.getDateCellValue();                  
                  value.put(fields.get(colIdx), new java.sql.Date(utilDate.getTime()));//date datatype must be in sql.Date object since entity field always use it*/
                } else {
                  //value.put(fields.get(colIdx), cell.getNumericCellValue());
                  dc.setConverter(cell.getNumericCellValue(),"#0.############");
                }
                break;
              default:
                dc.setConverter("");
                //value.put(fields.get(colIdx), null);
            }
            value.put(fields.get(colIdx), dc.getConverter());
          }
        }
        values.add(value);
      }
    }
    return values;
  }
}
