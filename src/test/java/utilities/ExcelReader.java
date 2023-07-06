package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void setupExcel(){

        try {
            workbook = new XSSFWorkbook("src/test/java/data/Luma_ExcelReader.xlsx");
            sheet = workbook.getSheet("LumaSheet1");

            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCellData(int rowNum, int cellNum){
        setupExcel();
        String cellData = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        return cellData;
    }

    public static int getCellInt(int rowNum, int cellNum){
        setupExcel();
        int cellData = (int) sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
        return cellData;
    }

}
