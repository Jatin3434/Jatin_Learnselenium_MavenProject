package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxAssignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/checkboxes");
		Thread.sleep(2000);
		
		
		//==============================================================================
		// clicking on checkbox 1
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkbox1.click();

		Thread.sleep(2000);

		//===================================================================================
		// unchecking on checkbox 2
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		checkbox2.click();

		//======================================================================================
		// verifying the title of the page

		WebElement heading1 = driver.findElement(By.xpath("//h3[.='Checkboxes']"));
		String verifyheading = heading1.getText();

		if (verifyheading.equals("Checkboxes")) {
			System.out.println("Test case passed as heading is corrrect");
		} else {
			System.out.println("Test case failed as heading is incorrect");
		}
		
		
		//=======================================================================================
		// verifying footer heading
		WebElement footer = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
		String verifyfooter = footer.getText();
		if (verifyfooter.equals("Powered by Elemental Selenium")) {
			System.out.println("footer heading is correct, test passed");
		}
		else {
			System.out.println("footer heading is incorrect, test failed");
		}
		
		driver.close();
	}

}
