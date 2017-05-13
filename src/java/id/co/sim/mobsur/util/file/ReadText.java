/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 * Read the text file
 * Supported extention: .txt
 * @created Jan 25, 2017
 * @author awal
 */
public class ReadText {

  private final MultipartFile file;//text file
  private final List<String> fields;//list of column name
  private final boolean hasHeader;//where to start read the data
  private final String textDelimiter;//character separator between two columns
  private final String fileName; //preserve for future use

  /**
   * The only constructor to access the instance
   * Prepare initial parameter
   * @param file
   * @param fields
   * @param hasHeader
   * @param textDelimiter
   * @param fileName 
   */
  public ReadText(MultipartFile file, List<String> fields, boolean hasHeader, String textDelimiter, String fileName) {
    this.file = file;
    this.fields = fields;
    this.hasHeader = hasHeader;
    this.textDelimiter = textDelimiter;
    this.fileName = fileName;
  }
  
  /**
   * Get the file contents
   * @return list of row of column of index and data contents
   * @throws IOException 
   */
  @SuppressWarnings("ConvertToTryWithResources")
  public List<Map<String,String>> getFileContents() throws IOException {
    //container
    List<Map<String,String>> values = new ArrayList();
    //buffering file before reading
    BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
    //container by line
    String line;
    //remove first line if the file has header
    if(hasHeader)
      br.readLine();
    //iterate through the line of file
    while((line = br.readLine()) != null) {
      String[] lineArr = line.split("\\"+textDelimiter); //aware of the escape character
      Map<String,String> value = new HashMap();
      for(int idxField = 0; idxField < fields.size(); idxField++)
        value.put(fields.get(idxField), lineArr[idxField]);
      values.add(value);
    }
    br.close();
    return values;
  }
}
