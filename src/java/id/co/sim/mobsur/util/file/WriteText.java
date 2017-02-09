/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @created Jan 28, 2017
 * @author awal
 */
public class WriteText {

  private final File file;
  private final List<String> titles;
  private final List<String> headers;
  private final List<List<String>> contents;
  private final String sheetName;
  private final String textDelimiter;
  
  public WriteText(File file, List<String> titles, List<String> headers, List<List<String>> contents, String sheetName, String textDelimiter) {
    this.file = file;
    this.titles = titles;
    this.headers = headers;
    this.contents = contents;
    this.sheetName = sheetName;
    this.textDelimiter = textDelimiter;
  }
  
  public void createFile() throws IOException {
    //be aware this is a new java 7 feature, avoid the object have not closed after execute
    try ( FileWriter fileWriter = new FileWriter(file)) { //object preparation
      //variable
      String newline = "\r\n";//return key and newline
      int idxCol = 0;
      
      //define column width, base on the longest value
      List<Integer> columnsLength = new ArrayList();
      for(String hdr : headers) {
        int longestVal = hdr.length();
        for(List<String> content : contents) {
          int valLen = content.get(idxCol).length();
          if(valLen > longestVal)
            longestVal = valLen;
        }
        columnsLength.add(longestVal);
        idxCol++;
      }
      
      // add title
      for (String title : titles) {
        fileWriter.append(title).append(newline);
      }
      fileWriter.append(newline);
      
      // add header
      fileWriter.append(textDelimiter);
      idxCol = 0;
      for(String header : headers) {
        fileWriter.append(" ").append(padRightTextWithSpace(header,columnsLength.get(idxCol++))).append(" ").append(textDelimiter);
      }
      fileWriter.append(newline);
      fileWriter.append(newline);
      
      // add detail
      for(List<String> content : contents) {
        fileWriter.append(textDelimiter);
        idxCol = 0;
        for(String val : content)
          fileWriter.append(" ").append(padRightTextWithSpace(val,columnsLength.get(idxCol++))).append(" ").append(textDelimiter);
        fileWriter.append(newline);
      }
    } //return key and newline
  }
  
  private String padRightTextWithSpace(String text, int length) {
    return String.format("%1$-" + length + "s", text);
  }

}
