package TestNG_Annotations;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenShot_WebPage {
	
	static WebDriver driver;
	@BeforeMethod
	void launch_Browser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	void takeScreenshot_page() throws IOException
	{
		File scr_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Target_file = new File("./Screenshot/image.png");
		FileHandler.copy(scr_file, Target_file);
	}
	
	@Test
	void takeScreenshot_Element() throws IOException
	{
		WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		File scr_file = logo.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/image1.png");
		FileHandler.copy(scr_file, target);
	}

	
	@AfterMethod
	void close_Browser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
