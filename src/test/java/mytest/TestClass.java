package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://practicesoftwaretesting.com/");
		Thread.sleep(3000);
		WebElement e1= driver.findElement(By.xpath("//h5[.=' Combination Pliers ']"));
		Thread.sleep(2000);
		e1.click();
		
		Thread.sleep(3000);
		WebElement e2= driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/h1"));
		String text= e2.getText();
		
		if(text.equals("Combination Pliers")) {
			System.out.println("heading of the product is correct, test passed");
		}
		else {
			System.out.println("heading is incprrect, test failed");
		}
		driver.close();
		
	}

}
