package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement drag = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(drag).perform();

		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();
		System.out.println("Page title is : " + driver.getTitle());


		//5
		driver.findElement(By.xpath("//div[text()='Avg Customer Rating']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
 		driver.findElement(By.xpath("//span[text()='Hair']")).click();
 		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
 		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
 		Thread.sleep(1000);
 		String filterApplied = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
 		System.out.println("Filter applied for the produect : "+filterApplied);
 		driver.findElement(By.xpath("(//span[contains(text(),'Paris Colour Protect Shampoo')])[2]")).click();
 		
 		Set<String> windowHandlesSet2 = driver.getWindowHandles();
 		List<String> windowHandlesList2 = new ArrayList<String>(windowHandlesSet2);
 		driver.switchTo().window(windowHandlesList2.get(2));
 		driver.findElement(By.xpath("//span[text()='175ml']")).click();

 		
 		String shampooPrice = driver.findElement(By.xpath("(//div[@class='price-info']//meta)[3]")).getAttribute("content");
		System.out.println("Price of the Shampoo : "+shampooPrice);
		driver.findElement(By.xpath("//div[@class='pull-left']//button")).click();
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(3000);
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']/div")).getText();
		String grandTotal1 = grandTotal.replaceAll("[^0-9]", "");
		int grandTotalInteger = Integer.parseInt(grandTotal1);
		System.out.println("Grand Total : "+grandTotalInteger);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='btn full fill']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='sticky-bottom proceed-cart-btn']//div)[4]")).click();	 
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String grandTotalfinal = driver.findElement(By.xpath("(//div[@class='value'])[2]/span")).getText();
		System.out.println("Grand total : "+grandTotalfinal);
		
		if(grandTotal.contains(grandTotalfinal))
			System.out.println("Grand total in both the pages are same");
		else
			System.out.println("Grand total in both the pages are different ");
		
	}
	}


