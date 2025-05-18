package alertAssignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuppAlertAssignmentMay14 {
	
	@Test
	public void AlertJsAlert() {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement button1= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
		button1.click();
		
		Alert message= driver.switchTo().alert();
		message.accept();
		WebElement text= driver.findElement(By.xpath("//p[@id='result']"));
		String text1= text.getText();
		System.out.println(text1);
		
		Assert.assertEquals(text1, "You successfully clicked an alert", "Test passsed successfully");
		
		
		driver.quit();
		
	}
	
	@Test
	public void JSConfirm() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
		Alert message2= driver.switchTo().alert();
		message2.accept();
		
		WebElement text2= driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
		String text= text2.getText();
		System.out.println(text);
		Assert.assertEquals(text, "You clicked: Ok", "Test passed");
		driver.quit();
	}

	@Test
	public void JSPrompt() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Alert message3= driver.switchTo().alert();
		message3.sendKeys("hello");
		message3.accept();
		
		WebElement text3= driver.findElement(By.xpath("//p[.='You entered: hello']"));
		String text= text3.getText();
		System.out.println(text);
		Assert.assertEquals(text, "You entered: hello", "Test passed");
		driver.quit();
	}
	
}
