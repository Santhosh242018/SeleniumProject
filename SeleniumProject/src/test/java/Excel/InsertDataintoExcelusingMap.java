package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataintoExcelusingMap {
	public static void main(String[] args) throws Throwable {
		FileInputStream file = new FileInputStream("./src/test/resources/DataDriven.xlsx");
		 Workbook book = WorkbookFactory.create(file);
		  Sheet sheet = book.getSheet("Map");
		  
		   LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		   data.put("10", "Hyderabad");
		   data.put("20", "Banglore");
		   data.put("30", "Pune");
		   data.put("40", "Delhi");
		   data.put("50", "Chennai");	   
		   int rownum=0;
		   for (Entry<String, String> m : data.entrySet()) {
			    Row row = sheet.createRow(rownum++);
			    row.createCell(0).setCellValue((String) m.getKey());
			    row.createCell(1).setCellValue((String) m.getValue());
		}
		   FileOutputStream ofile = new FileOutputStream("./src/test/resources/DataDriven.xlsx");
		   book.write(ofile);
		   book.close();
	}

}
