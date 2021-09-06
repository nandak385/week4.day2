package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		
		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		WebElement menFash=driver.findElement(By.xpath("//li[@class='navlink lnHeight']"));
		Actions click=new Actions(driver);
		click.moveToElement(menFash).perform();

		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

	
		String  sportsShoesCount=driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		String str=sportsShoesCount.replaceAll("[^0-9]", "");
		int count=Integer.parseInt(str);
		System.out.println("The count of the sports shoes: " +count);

		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		WebElement ele=driver.findElement(By.xpath("//ul[@class='sort-value']//li[2]"));
		String sorted=ele.getText();
		ele.click();
		Thread.sleep(2000);
		System.out.println(sorted);

	
		String sorted1 ="Price Low To High";

		if(sorted.equals(sorted1)) {
			System.out.println("The items are displayed sorted correctly");
		}
		else {

			System.out.println("The items are not displayed sorted correctly");
		}


		WebElement blue=driver.findElement(By.xpath("(//p[text()='VSS Blue Training Shoes'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(blue).perform();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//div[contains(@class,'center quick-view-bar')])[17]")).click();

		String price = driver.findElement(By.className("payBlkBig")).getText();
		System.out.println("Price: " + price);
		String discount = driver.findElement(By.className("percent-desc")).getText();
		System.out.println("Discount percentage: " + discount);

		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/snapdeal.png");
		FileUtils.copyFile(src1, dst);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.close();
	

	}

}


