package utilities;

import cucumber.api.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilities {

    public static List<List<String>> getListData(String path, String sheetName, int columnCount) {
        List<List<String>> returnList = new ArrayList<>();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount; i++) {
            List<String> list = new ArrayList<>();
            Row row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                list.add(cell.getStringCellValue());
            }
            returnList.add(list);
        }
        return returnList;
    }

    public static void writeExcel(String path, Scenario scenario, String browsername, String time) {
        File file = new File(path);

        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Results");
            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getId());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus());

            cell = row.createCell(2);
            cell.setCellValue(time);

            cell = row.createCell(3);
            cell.setCellValue(browsername);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileInputStream inputStream = null;
            Workbook workbook = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String sheetName = workbook.getSheetName(0);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rowCount);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getId());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus());

            cell = row.createCell(2);
            cell.setCellValue(time);

            cell = row.createCell(3);
            cell.setCellValue(browsername);
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
