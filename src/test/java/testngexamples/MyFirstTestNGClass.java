package testngexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestNGClass {
	
	@Test
	public void test01() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/");
		WebElement dropdown= driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a"));
		dropdown.click();
		driver.navigate().back(); 
		driver.navigate().forward();
		driver.navigate().refresh();
		
		WebElement ddtitle= driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		
		String title= ddtitle.getText();
		
		Assert.assertEquals(title, "Dropdown List");
		
		System.out.println("failed, title does not match");
		
		driver.quit();
		
		
		
		
	}

	@Test
	public void Selectdropdown() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/");
		WebElement dropdown= driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a"));
		dropdown.click();
		
		WebElement drop= driver.findElement(By.xpath("//select[@id='dropdown']"));
		
		Select dd= new Select(drop);
		dd.selectByVisibleText("option 2");
		dd.selectByValue("1");
		dd.selectByIndex(2);
		driver.quit();
		
		
		
	}
	
}
