package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.ConstantsUtils;

import java.io.*;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "getJSONData")
    public Object[] getTestDataUsingJSON() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject object = (JSONObject) jsonParser.parse(new FileReader(ConstantsUtils.jsonFile));
        JSONArray arry = (JSONArray) object.get("userLogin");
        Object[] obj = new Object[arry.size()];
        for(int i=0; i<arry.size();i++){
            obj[i]= arry.get(i);
        }
        return  obj;
    }



    @org.testng.annotations.DataProvider(name = "getExcelData")
    public Object[][] readDataFromExcel() throws IOException {
        FileInputStream ip = new FileInputStream(ConstantsUtils.excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(ip);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for(int i=0;i<rows;i++){
            XSSFRow row = sheet.getRow(i+1);
            for(int j=0; j<cols;j++){
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType){
                    case STRING :
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = cell.getNumericCellValue();
                        break;
                }
            }
        }

        return  data;
    }

}
