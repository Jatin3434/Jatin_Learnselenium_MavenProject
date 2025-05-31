package seleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeSoftwareTestingAssignment {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchingbrowser() {
		driver = new ChromeDriver();
		driver.get("https://practicesoftwaretesting.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
	}
	
	@Test
	public void Testcase1() throws InterruptedException {
		WebElement categories= driver.findElement(By.xpath("//li[@class='nav-item dropdown']"));
		categories.click();
		Thread.sleep(1000);
		
		WebElement powertool= driver.findElement(By.xpath("//a[.='Power Tools']"));
		Actions a1= new Actions(driver);
		a1.moveToElement(powertool).build().perform();
		powertool.click();
		
		WebElement e3= driver.findElement(By.xpath("//div[@class='checkbox']//div[2]/label/input"));
		e3.click();
		
		WebElement producttext= driver.findElement(By.xpath("//h5[.=' Random Orbit Sander ']"));
		String text= producttext.getText();
		System.out.println(text);
		Assert.assertEquals(text, "Random Orbit Sander");
	}
	
	@AfterMethod
	public void quitbrowser() {
		driver.quit();
	}
}
