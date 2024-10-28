package JsonData;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDatafromJsonfile {

	public static void main(String[] args) throws Throwable {
		//Step1 :  Getting the connection of the File
		File file = new File("./src/test/resources/JsonData.json");
		ObjectMapper object = new ObjectMapper();
		JsonNode data = object.readTree(file);
		
		String Browser = data.get("browser").asText();
		String URL = data.get("url").asText();
		String Username = data.get("username").asText();
		String Password = data.get("password").asText();
		
		System.out.println(Browser);
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.close();
	}

}
