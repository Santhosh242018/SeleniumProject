package VTiger_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Organizations {

	public static void main(String[] args) {
		
		//Step 1 :  Launch the Browser and  VTiger Application
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Login Page Title : " + driver.getTitle());
		
		//Step 2 : Enter the login credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3 : Navigate to Organizations page and enter the OrganizationName, Phone number and Email
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("QSpiders");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1122334455");
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		//Step 4 : Check whether record is created or not
		WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String msg = text.getText();
		System.out.println("Record Created Message : " + msg);
		if(text.isDisplayed())
		{
			System.out.println("Record is Created Successfully - Test Case Passed");
		}
		else
		{
			System.out.println("Record is not Created - Test Case Failed");
		}
	
		driver.quit();	
	}

}
