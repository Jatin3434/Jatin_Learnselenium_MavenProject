package fillForm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FillFormSignIn {
	
	@Test (groups= "smoke")
	public void testResgisterUser() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicesoftwaretesting.com");
		driver.manage().window().maximize();
		
		WebElement signin= driver.findElement(By.xpath("//a[.='Sign in']"));						//cliking on sign in link
		signin.click();
		
		WebElement register= driver.findElement(By.linkText("Register your account"));				//clicking on register link
		register.click();
		
		driver.findElement(By.id("first_name")).sendKeys(new Faker().name().firstName());			//typing first name
		driver.findElement(By.id("last_name")).sendKeys(new Faker().name().lastName());				//typing last name
		
		//using javascripexecutor as not able to select a date using sendkeys faker method
		WebElement dobField = driver.findElement(By.id("dob"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='1995-03-21';", dobField);								//selecting dob*
		
		driver.findElement(By.id("street")).sendKeys(new Faker().address().streetAddress());		//selecting street address
		driver.findElement(By.id("postal_code")).sendKeys(new Faker().address().zipCode());			//selecting zipcode
		driver.findElement(By.id("city")).sendKeys(new Faker().address().city());					//selecting city name
		driver.findElement(By.id("state")).sendKeys(new Faker().address().state());					//selecting state 


		WebElement drop= driver.findElement(By.id("country"));  									//selecting country
		drop.click();
		
		Select dd= new Select(drop);
		//dd.selectByValue(new Faker().country());
		dd.selectByVisibleText("Canada");
		driver.findElement(By.id("phone")).sendKeys("9568954125");									//typing phone number
		driver.findElement(By.id("email")).sendKeys(new Faker().internet().emailAddress());			//typing email address
		driver.findElement(By.id("password")).sendKeys("Hacker7889#");								//typing password*
		WebElement button= driver.findElement(By.xpath("//button[@data-test='register-submit']"));	//clicking on button
		button.click();
		String registerbutton= button.getText();													//getting text and typing on console
		System.out.println(registerbutton);
		
		Assert.assertEquals(registerbutton, "Register", "Test passed as Text matches");											//comparing actual and expected button text
		driver.quit();																				//quitting the website
			
		
	}
	
	
}
