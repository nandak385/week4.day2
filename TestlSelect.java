package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestlSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement sel1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement sel5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Actions builder = new Actions(driver);
		builder.click(sel1).clickAndHold().perform();
		builder.click(sel5).perform();

		

		

	}

}
