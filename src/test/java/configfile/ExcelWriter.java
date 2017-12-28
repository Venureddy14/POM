package configfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	public static void WriteToExcel(int sheetindex,int rowindex,int cellindex, String value)
	{
		 Workbook wb = null;
		 
		
		try{
		File fx = new File("C:\\Users\\zubairhussains\\workspace\\POMproject\\TestData\\testData.xlsx");
		FileInputStream fix = new FileInputStream(fx);
		//wb = WorkbookFactory.create(fix);
		 	
		 wb =new XSSFWorkbook(fix);
		
		Sheet sh=wb.getSheetAt(sheetindex);
		
		
		
		//sh.createRow(0).createCell(2).setCellValue("vallue");
		sh.getRow(rowindex).createCell(cellindex).setCellValue(value);
	
		FileOutputStream fout=new FileOutputStream(fx);
		
		wb.write(fout);
		
		fout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

