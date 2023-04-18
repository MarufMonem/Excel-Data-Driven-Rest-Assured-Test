import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public  ArrayList<String> getData(String testcaseName) throws IOException {
        ArrayList <String> dataStorage = new ArrayList<>();
        FileInputStream fis = new FileInputStream("X:\\Career\\Learning\\API\\Excel_Data_Driven\\excelDataDrivenData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheetCount = workbook.getNumberOfSheets();
        for(int i=0; i<sheetCount; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("main")){
                XSSFSheet tagetSheet= workbook.getSheetAt(i);

                Iterator<Row> rows = tagetSheet.iterator();
                Row firstRow = rows.next(); // comes to the first row

                Iterator<Cell> cells = firstRow.cellIterator();
                int count =0;
                int columnNumber = 0;
                while (cells.hasNext()){
                    Cell cellValue = cells.next();
                    if(cellValue.getStringCellValue().equalsIgnoreCase("Testcases")){
                        columnNumber=count;
                        break;
                    }
                    count++;
                }
                System.out.println("target cell number: " + columnNumber ) ;

//                Finding the purchase testcase
                while (rows.hasNext()){
                    Row r = rows.next();
                    if(r.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(testcaseName)){
                        Iterator<Cell> c = r.cellIterator();
                        while (c.hasNext()){
                            String cellValue = c.next().getStringCellValue();
                            System.out.println("Purchase cell value: " + cellValue);
                            dataStorage.add(cellValue);
                        }
                    }
                }
            }

        }
        return dataStorage;
    }
}
