package excelUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader
{
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelReader(String filepath) throws IOException
	{
		FileInputStream fis;
		
		try
		{
			fis = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(fis);
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getData(int sheetnumber, int row, int col)
	{
		sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int  getRow(int sheetnumber)
	{
		int RowCount = workbook.getSheetAt(sheetnumber).getLastRowNum();
		System.out.println("Total number of rows available in sheet is ..." +RowCount);
		return RowCount;
	}
	
}
