package Debugg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.WebDriver_Utility;

public class Sample2 {
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriver_Utility WU = new WebDriver_Utility();
		WU.maximizewindow(driver);
		driver.get("https://www.amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puma");

	}

}
