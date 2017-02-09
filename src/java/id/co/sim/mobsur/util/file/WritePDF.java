/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * @created Jan 28, 2017
 * @author awal
 */
public class WritePDF {

  private final File file;
  private final List<String> titles;
  private final List<String> headers;
  private final List<List<String>> contents;
  private final String sheetName;
  
  public WritePDF(File file, List<String> titles, List<String> headers, List<List<String>> contents, String sheetName) {
    this.file = file;
    this.titles = titles;
    this.headers = headers;
    this.contents = contents;
    this.sheetName = sheetName;
  }
  
  public void createFile() throws IOException, COSVisitorException {
    //object preparation
    PDDocument doc = new PDDocument();
    
    //portrait variable
    final int pageWidth = 595; //page width
    final int pageHeight = 842; //page height
    //other variable
    final int downMargin = 10;//space between page contain and page bottom border
    final int leftMargin = 50;//space between page contain and page left border
    final int rowHeight = 10;//line height
    final int cellMargin = 2;//space between text and line
    final int cols = headers.size();
    final int maxRowsPerPage = (pageHeight/rowHeight) - (2*downMargin/rowHeight);//move to next page when reach this limit
    final int titleRows = titles.size() + 1;//plus space
    final int startLineY = (maxRowsPerPage - titleRows) * rowHeight;//top position where object start to draw
    final int recordsNum = contents.size();
    int num = 0;
    int idxCol = 0;
    
    //define column width, base on the longest value
    List<Integer> columnsLength = new ArrayList();
    for(String header : headers) {
      int longestVal = header.length();
      for(List<String> content : contents) {
        int valLen = content.get(idxCol).length();
        if(valLen > longestVal)
          longestVal = valLen;
      }
      columnsLength.add(longestVal * 4);
      idxCol++;
    }
    
    //set table width
    int tableWidth = leftMargin;
    for(int length : columnsLength)
      tableWidth += length + cellMargin;
    
    //loop through page
    while(recordsNum > num) {
      //set table height
      int tableRows = recordsNum - num + 1 < maxRowsPerPage - titleRows ? recordsNum - num + 1 : maxRowsPerPage - titleRows;//plus header
      //page preparation
      PDPage page = new PDPage();
      PDRectangle pdr = new PDRectangle(pageWidth, pageHeight);
      page.setMediaBox(pdr);
      doc.addPage(page);
      //be aware this is a new java 7 feature, avoid the object have not closed after execute
      try (PDPageContentStream contentStream = new PDPageContentStream(doc, page)) {
        contentStream.setLineWidth(1);
        //draw table horizontal line
        int lineCordY = downMargin + startLineY;
        for (int i = 0; i <= tableRows; i++) {
          contentStream.drawLine(leftMargin,lineCordY,tableWidth,lineCordY);
          lineCordY -= rowHeight;
        }
        //draw table vertical line
        int lineCordX = leftMargin;
        lineCordY = downMargin + startLineY;
        int endLineY = downMargin + startLineY - (tableRows * rowHeight);
        for (int i = 0; i <= cols; i++) {
          contentStream.drawLine(lineCordX,endLineY,lineCordX,lineCordY);
          if(i < cols)
            lineCordX += columnsLength.get(i) + cellMargin;
        }
        
        //now add the text
        contentStream.setFont(PDType1Font.HELVETICA_BOLD,6);
        
        //add title
        int textx = leftMargin;
        int texty = downMargin + cellMargin + (maxRowsPerPage - 1) * rowHeight;
        for(String title : titles) {
          contentStream.beginText();
          contentStream.moveTextPositionByAmount(textx,texty);
          contentStream.drawString(title);
          contentStream.endText();
          texty -= rowHeight;
        }
        
        //add header
        textx = leftMargin + cellMargin;
        texty -= rowHeight;
        idxCol = 0;
        for(String header : headers) {
          contentStream.beginText();
          contentStream.moveTextPositionByAmount(textx,texty);
          contentStream.drawString(header);
          contentStream.endText();
          textx += columnsLength.get(idxCol++) + cellMargin;
        }

        //add detail
        contentStream.setFont(PDType1Font.HELVETICA,5);
        textx = leftMargin + cellMargin;
        texty -= rowHeight;
        for(List<String> content : contents) {
          num++;
          idxCol = 0;
          for(String val : content) {
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx,texty);
            contentStream.drawString(val);
            contentStream.endText();
            textx += columnsLength.get(idxCol++) + cellMargin;
          }
          texty -= rowHeight;
          textx = leftMargin + cellMargin;
        }
      }
    }
    doc.save(file);    
  }

}
