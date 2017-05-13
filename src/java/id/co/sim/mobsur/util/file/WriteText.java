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
 * Write the text file with padding to align columns
 * Output extention: .txt
 * @created Jan 28, 2017
 * @author awal
 */
public class WriteText {

  private final File file;//output file
  private final List<String> titles;//list of description of document
  private final List<String> headers;//list of column headers
  private final List<List<String>> contents;//excle file contents
  private final String sheetName;//future used
  private final String textDelimiter;//character separator between two columns
  
  /**
   * The only constructor to access the instance
   * Prepare initial parameter
   * @param file
   * @param titles
   * @param headers
   * @param contents
   * @param sheetName
   * @param textDelimiter 
   */
  public WriteText(File file, List<String> titles, List<String> headers, List<List<String>> contents, String sheetName, String textDelimiter) {
    this.file = file;
    this.titles = titles;
    this.headers = headers;
    this.contents = contents;
    this.sheetName = sheetName;
    if(textDelimiter == null || textDelimiter.equals(""))
      this.textDelimiter = "|";
    else
      this.textDelimiter = textDelimiter;
  }
  
  /**
   * Create the text file
   * @throws IOException 
   */
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
  
  //right padding text with space
  private String padRightTextWithSpace(String text, int length) {
    return String.format("%1$-" + length + "s", text);
  }

}
