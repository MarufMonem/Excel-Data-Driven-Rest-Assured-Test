import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class dataDriven {
    public static void main(String[] args) throws IOException {


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
                    count++;
                    if(cellValue.getStringCellValue().equalsIgnoreCase("Testcases")){
                        System.out.println("target cell number: " + count ) ;
                        columnNumber=count;
                    }
                }
            }
        }



    }
}
