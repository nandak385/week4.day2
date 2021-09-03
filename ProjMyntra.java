package week4.day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;





import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjMyntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String replaceAll = text.replaceAll("[^0-9]", "");
		System.out.println(text.replaceAll("[^0-9]", ""));
		int parseInt = Integer.parseInt(replaceAll);
		
		String text1 = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		String replaceAll1 = text1.replaceAll("[^0-9]", "");
		System.out.println(text1.replaceAll("[^0-9]", ""));
		int parseInt1 = Integer.parseInt(replaceAll1);
		
		String text2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String replaceAll2 = text2.replaceAll("[^0-9]", "");
		System.out.println(text2.replaceAll("[^0-9]", ""));
		int parseInt2 = Integer.parseInt(replaceAll2);
		
		int sum = parseInt1+parseInt2;
		
		if (parseInt == sum) {
			System.out.println("It's matched!");
			
		}else {
			System.out.println("not matched!");

		}
		
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		Thread.sleep(2000);
		List<WebElement> duke =  driver.findElements(By.tagName("h3"));
		
		for (int i = 0; i < duke.size(); i++) {
			String text3 = duke.get(i).getText();
			if (text3.contains("Duke")) {
				System.out.println("All listed products are Duke!");
				
			}else {
				System.out.println("It's not Duke!");

			}
			
		}

		WebElement hoverElement2 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		action.moveToElement(hoverElement2).perform();
	    	
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		Thread.sleep(1000);

		WebElement price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']"));
        String text3 = price.getText();
        System.out.println("The price of 1st product is "+text3);
        
        driver.findElement(By.xpath("(//li[@class='product-base'])[1]//a")).click();
    	Set<String> windowHandleSet= driver.getWindowHandles();
    	List<String> windowHandleList=new ArrayList<String>(windowHandleSet);
    	driver.switchTo().window(windowHandleList.get(1));
        
        
        File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	File dst = new File("./snap/myntra.png");
    	FileUtils.copyFile(src1, dst);

    	System.out.println("Screenshot page title: " + driver.getTitle());
    	
    	driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
    	driver.close();
		
	}

}
