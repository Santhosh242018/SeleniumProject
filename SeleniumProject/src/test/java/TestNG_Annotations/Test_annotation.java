package TestNG_Annotations;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test_annotation {
@Test(priority=1, invocationCount = 2)	
	void startCar() {
		System.out.println("Car Started....");
		Reporter.log("Hello World", true);
	}

}
