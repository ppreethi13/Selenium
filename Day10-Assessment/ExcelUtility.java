package pomutilities1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public static String getData(
            String sheetName,
            int rowNumber,
            int columnNumber) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "./src/test/resources/DDT/saucedemoexcel.xlsx");

            Workbook workbook =
                    WorkbookFactory.create(fis);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            Row row =
                    sheet.getRow(rowNumber);

            String data =
                    row.getCell(columnNumber).toString();

            workbook.close();
            fis.close();

            return data;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}