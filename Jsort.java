package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
		WebElement sel1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement sel6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		Point location = sel6.getLocation();
		int x = location.getX();
		int y = location.getY();
        
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(sel1, x, y).perform();

	}

}
