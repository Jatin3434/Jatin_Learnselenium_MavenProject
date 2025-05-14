package testngexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQAassignment {
	
	@Test
	public void Dropdown1 () {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
		WebElement selectoption= driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div/div[2]/div"));
		selectoption.click();
		
//		WebElement option1= driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div/div[1]/div[1]"));
//		option1.click();
//		Assert.assertEquals(option1, "Group 1, option 1");
		
		WebElement option2= driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div/div[1]/div[1]"));
		option2.click();
		String option2title= option2.getText();
		System.out.println(option2title);
		//Assert.assertEquals(option2title, "Select Option");
		
		driver.close();
		
	}
	
	@Test
	public void dropdown2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
		
		WebElement selectoption= driver.findElement(By.xpath("//*[@id=\"selectOne\"]/div/div[1]"));
		selectoption.click();
//		WebElement mroption= driver.findElement(By.xpath("//*[@id=\"selectOne\"]/div/div[1]/div[1]"));
//		mroption.click();
		driver.close();
	}
	
	@Test
	public void dropdown3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
		
		WebElement selectdrop= driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
		selectdrop.click();
		Select drop= new Select(selectdrop);
		
		drop.selectByIndex(10);
		String actualcolor1= drop.getFirstSelectedOption().getText();
		Assert.assertEquals(actualcolor1, "Aqua", "Color selected text matches ");
		
		drop.selectByValue("1");
		String actualcolor2= drop.getFirstSelectedOption().getText();
		Assert.assertEquals(actualcolor2, "Blue", "Color selected text matches ");
		
		drop.selectByVisibleText("Green");
		String actualcolor3= drop.getFirstSelectedOption().getText();
		Assert.assertEquals(actualcolor3, "Green", "Color selected text matches ");
		
		
		driver.quit();
		
		
		
	}

}
