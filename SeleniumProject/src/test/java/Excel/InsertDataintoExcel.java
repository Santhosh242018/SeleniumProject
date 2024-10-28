package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataintoExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream file = new FileInputStream("./src/test/resources/DataDriven.xlsx");
		 Workbook book = WorkbookFactory.create(file);
		  Sheet sheet = book.getSheet("Insert");
		  
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  
		   List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		   
		   for(int i=0; i<alllinks.size();i++)
		   {
			   Row row = sheet.createRow(i);
			    Cell cell = row.createCell(0);
			    cell.setCellValue(alllinks.get(i).getAttribute("href"));
		   }
		   
		   FileOutputStream ofile = new FileOutputStream("./src/test/resources/DataDriven.xlsx");
		   book.write(ofile);
		   book.close();
		   
		   
		   driver.close();

	}

}
