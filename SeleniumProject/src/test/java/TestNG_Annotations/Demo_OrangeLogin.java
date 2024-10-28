package TestNG_Annotations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo_OrangeLogin {
    WebDriver driver;

    @BeforeMethod
    void openBrower()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void login()
    {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    void closeBrowser()
    {
        String title = driver.getTitle();
        if(title.contains("OrangeHRM"))
        {
            Reporter.log("TestCase Passed", true);
        }
        else
        {
            Reporter.log("TestCase Failed", false);
        }
        driver.quit();
    }
}

