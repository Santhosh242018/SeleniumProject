package TestNg_Practice;

import org.testng.annotations.Test;

public class Simple_Test {
	
	@Test(priority=1)
	public void createProduct()
	{
		System.out.println("Product Created");
	}
	@Test(priority=2)
	public void modifyProduct()
	{
		System.out.println("Modify Product");
	}
	@Test(priority=3)
	public void deleteProduct()
	{
		System.out.println("Delete Product");
	}
}
