package practice2023;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindMinValueProductAndClickOnIT {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("https://flipkart.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void findMaxOfItems() {
		driver.findElement(By.name("q")).sendKeys("Machanical Keyboard", Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='_30jeq3']"));
		int min = Integer.MIN_VALUE;
		HashMap<Integer, WebElement> map = new HashMap<>();
		for (WebElement a : list) {
			String prices = a.getText().replace('₹', ' ').replaceAll(",", "").trim();
			Integer intPrices = Integer.valueOf(prices);
			map.put(intPrices, a);
			min = Math.max(min, intPrices);
		}
		System.out.println(min);

		WebElement maxPrice = map.get(min);
		maxPrice.click();

	}
}
