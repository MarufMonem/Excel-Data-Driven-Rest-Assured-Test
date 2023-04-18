import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class dataDriven {
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("X:\\Career\\Learning\\API\\Excel_Data_Driven\\excelDataDrivenData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheetCount = workbook.getNumberOfSheets();
        for(int i=0; i<sheetCount; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("main")){
                XSSFSheet tagetSheet= workbook.getSheetAt(i);
            }
        }



    }
}
