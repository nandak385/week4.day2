package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jslect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement sel1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement sel5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Actions builder = new Actions(driver);
		builder.click(sel1).clickAndHold().perform();
		builder.click(sel5).perform();

	}

}
