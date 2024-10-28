package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchdatafromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream file = new FileInputStream("./src/test/resources/DataDriven.xlsx");
		 Workbook book = WorkbookFactory.create(file);
		  Sheet sheet = book.getSheet("Insert");
		  
		  int rownum = sheet.getLastRowNum()+1;
		  System.out.println(rownum);
		  
		  for(int i=0;i<rownum; i++)
		  {
			  Row row = sheet.getRow(i);
			  for(int j=0; j<row.getLastCellNum();j++)
			  {
				    Cell cell = row.getCell(j);
				    String links = cell.getStringCellValue();
				    System.out.println(links);
			  }
		  }

	}

}
