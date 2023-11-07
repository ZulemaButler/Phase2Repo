package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static List<Map<String, String>> readExcelSheet(String filePath, String sheetName){

        FileInputStream fileInputStream = null;
        List<Map<String, String>> excelData = new ArrayList<>();

        try{
            fileInputStream = new FileInputStream(filePath);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            Sheet excelSheet = xssfWorkbook.getSheet(sheetName);
            // this row is just for keys
            Row headerRow = excelSheet.getRow(0);
            for (int rows = 1;  rows < excelSheet.getPhysicalNumberOfRows(); rows++){
                Row row = excelSheet.getRow(rows);
                Map<String, String> rowMap = new LinkedHashMap<>();
                // here we are taking all the columns
                for (int col = 0; col < row.getPhysicalNumberOfCells(); col++){
                    String key = headerRow.getCell(col).toString();
                    String value =  row.getCell(col).toString();
                    rowMap.put(key, value);
                }
            excelData.add(rowMap);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return excelData;
    }
}
