package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;
	
	String filePath = System.getProperty("user.dir") + "/src/test/java/data/AssessmentEx1Locators.xlsx";
	
	File file = new File(filePath);
	
	
	public FileInputStream getExcelFile() {
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured file not found");
		}
		
		return fis;
		
	}
	
	public Object [][] retreiveExceldata() throws IOException{
		
		fis = getExcelFile();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int numberOfRows = sheet.getLastRowNum()+1;
		int numberOfCols = 1;
		
		String  data[][] = new String[numberOfRows][numberOfCols];
		
		for (int i = 0; i < numberOfRows; i++) {
			
			for (int j = 0; j < 1; j++) {
				XSSFRow row = sheet.getRow(i);
				data[i][j] = row.getCell(j).toString();
			}
		}
		
		wb.close();
		return data;	
	}

}
