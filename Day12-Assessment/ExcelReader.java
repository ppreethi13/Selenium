package pomutilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public static String getData(
            String sheetName,
            int rowNumber,
            int columnNumber) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {

            // Direct path to the Excel file
            File excelFile = new File(
                    "src/test/resources/TestData.xlsx");

            System.out.println(
                    "Excel file path: "
                    + excelFile.getAbsolutePath());

            System.out.println(
                    "Excel file exists: "
                    + excelFile.exists());


            if (!excelFile.exists()) {

                throw new RuntimeException(
                        "TestData.xlsx NOT FOUND at: "
                        + excelFile.getAbsolutePath());
            }


            // Open Excel
            inputStream =
                    new FileInputStream(excelFile);

            workbook =
                    WorkbookFactory.create(inputStream);


            // Check sheet
            if (workbook.getSheet(sheetName) == null) {

                throw new RuntimeException(
                        "Sheet not found: "
                        + sheetName);
            }


            // Read cell
            DataFormatter formatter =
                    new DataFormatter();

            String data =
                    formatter.formatCellValue(
                            workbook
                                    .getSheet(sheetName)
                                    .getRow(rowNumber)
                                    .getCell(columnNumber));


            // Print exactly what was read
            System.out.println(
                    "Excel Data -> "
                    + "Sheet: " + sheetName
                    + " | Row: " + rowNumber
                    + " | Column: " + columnNumber
                    + " | Value: [" + data + "]");


            return data;


        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to read Excel data.",
                    e);

        } finally {

            try {

                if (inputStream != null) {
                    inputStream.close();
                }

                if (workbook != null) {
                    workbook.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}