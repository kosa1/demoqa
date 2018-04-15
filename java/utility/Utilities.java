package utility;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


public class Utilities {

    public static Object[][] getTableArrayExcel(String filePath, String sheetName)
    {
        String[][] tabArray = null;
        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            XSSFWorkbook excelWBook = new XSSFWorkbook(excelFile);
            XSSFSheet excelWSheet = excelWBook.getSheet(sheetName);


            int totalRows = excelWSheet.getLastRowNum();
            int totalColumns = 14;   // change total colums
            DataFormatter dataFormatter = null;
            tabArray = new String[totalRows][totalColumns];


            for(int i=0; i<totalRows; i++){
                for(int j=0; j<totalColumns; j++) {
                    // temp cell
                    Cell cell = excelWSheet.getRow(i+1).getCell(j); // rownum is plus 1 because it started from second row in excel
                    dataFormatter = new DataFormatter();    // dataFormatter class helps to get values as string
                    String value = dataFormatter.formatCellValue(cell);
                    System.out.print(value + " |");
                    tabArray[i][j] = value;
                }
                System.out.println();
            }
        }catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return tabArray;
    }

    public static void takeScrenshot(WebDriver driver) {
        DateFormat dateFormat = new SimpleDateFormat("H_mm_ss_SSS");
        Date date = new Date();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String dateTemp = dateFormat.format(date);
            String temp = "C:\\Users\\Lukasz\\Desktop\\mavenTest\\testshop\\Screenshots\\screenshot" + dateTemp +".png";
            System.out.println(temp);
            FileUtils.copyFile(scrFile, new File(temp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String addRandomData(String text) {
        DateFormat dateFormat = new SimpleDateFormat("H_mm_ss_SSS");
        Date date = new Date();

        String dateTemp = dateFormat.format(date);
        text = dateTemp + text;
        return  text;

    }
}

