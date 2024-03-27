package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {
    public static String readTestDataFromExcel(String filePath, String sheetName, int rowIndex, int cellIndex) {
        try (FileInputStream inputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name " + sheetName + " not found.");
            }

            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                throw new IllegalArgumentException("Row index " + rowIndex + " is invalid.");
            }

            Cell cell = row.getCell(cellIndex);
            if (cell == null) {
                throw new IllegalArgumentException("Cell index " + cellIndex + " is invalid.");
            }

            return cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
