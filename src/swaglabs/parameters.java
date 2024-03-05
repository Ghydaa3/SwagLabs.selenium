package swaglabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {

	static WebDriver driver = new ChromeDriver();
	static String website = "https://www.saucedemo.com/";
	static String name = "standard_user";
	static String password = "secret_sauce";

	static void login() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement Button = driver.findElement(By.id("login-button"));
		username.sendKeys(name);
		pass.sendKeys(password);
		Button.click();
	}

	static void add(String... items) {

		List<WebElement> addButtons = driver.findElements(By.className("btn"));
		List<WebElement> addText = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < addText.size(); i++) {
			String MyItem = addText.get(i).getText();

			if (containitemName(MyItem, items)) {
				addButtons.get(i).click();
			}

		}

	}

	private static boolean containitemName(String neededItem, String... allItems) {

		for (String itemName : allItems) {

			if (neededItem.contains(itemName)) {
				return true;
			}
		}

		return false;
	}

	static void logout() throws InterruptedException {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("reset_sidebar_link")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();

	}

}
