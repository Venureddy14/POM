package configfile;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static  String config_excelreader(int sheetindex,int rowindex,int cellindex)
	{
		 Workbook wb = null;
		 String return_string=null;
		
		try{
		File fx = new File("C:\\Users\\zubairhussains\\workspace\\POMproject\\TestData\\testData.xlsx");
		FileInputStream fix = new FileInputStream(fx);
		wb = WorkbookFactory.create(fix);
		Sheet sh=wb.getSheetAt(sheetindex);
		 
		return_string =sh.getRow(rowindex).getCell(cellindex).getStringCellValue();	
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return return_string;
	}

}
