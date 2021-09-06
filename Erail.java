package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement click = driver.findElement(By.id("txtStationFrom"));
		click.clear();
		click.sendKeys("ms");
		click.sendKeys(Keys.ENTER);
		
		WebElement click1 = driver.findElement(By.id("txtStationTo"));
		click1.clear();
		click1.sendKeys("mdu");
		click1.sendKeys(Keys.ENTER);

		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		WebElement train = driver.findElement(By.className("DataTable TrainList TrainListHeader"));
		WebElement total = train.findElement(By.className("Click on train number to View fare and schedule"));
		System.out.println(total);
		
	}

}
