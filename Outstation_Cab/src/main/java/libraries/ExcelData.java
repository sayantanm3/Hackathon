package libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData {
	public void WriteData(int r, int c,String string) throws IOException
	{
       
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\libraries\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row2=sheet.createRow(r);
		row2.createCell(c).setCellValue(string);
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\libraries\\Data.xlsx");
        workbook.write(outputStream);
        workbook.close();
	
			}
		
	
	///******FOR DEBUGGING*****///
	/*
			public static void main(String[] args) throws IOException
			{
				ExcelData ex = new ExcelData();
				ex.WriteData(1, 1,"Hello");
						
			}
	*/
}
