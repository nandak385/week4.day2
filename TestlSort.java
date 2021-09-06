package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestlSort {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		WebElement sel1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
//		WebElement sel6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
//		
//		Point location = sel6.getLocation();
//		int x = location.getX();
//		int y = location.getY();
//        
//		Actions builder = new Actions(driver);
//		builder.dragAndDropBy(sel1, x, y).perform();
		
		
		Actions action = new Actions(driver);
	    List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sortable']//li"));
	    WebElement sel1 = list.get(0);
	    WebElement sel6 = list.get(5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    action.click(sel1).clickAndHold().moveToElement(sel6).moveByOffset(0, 5).release().build().perform();
	}

}
