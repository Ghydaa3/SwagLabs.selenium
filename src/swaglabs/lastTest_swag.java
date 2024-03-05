package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lastTest_swag extends parameters {

	@BeforeTest
	public void preTest() {
		driver.get(website);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void addTwoTest() throws InterruptedException {
		login();

		add("Backpack", "Fleece");
		Thread.sleep(2000);
		logout();

	}

	@Test(priority = 2)
	public void addThreeTest() throws InterruptedException {
		login();

		add("Fleece", "Onesie", "Bike");
		Thread.sleep(2000);
		logout();
	}
	
	@Test(priority=3)
	public void addrandomItem() throws InterruptedException {
		login();
		add("Bike Light" , "Fleece Jacket" , "Bolt T-Shirt" , "Test.allTheThingsf");
		Thread.sleep(2000);
		logout();
	}

}
