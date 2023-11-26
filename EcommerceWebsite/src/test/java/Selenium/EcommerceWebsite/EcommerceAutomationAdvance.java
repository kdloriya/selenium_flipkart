package Selenium.EcommerceWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceAutomationAdvance {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		google(driver);
		form(driver);
		driver.quit();

	}
	
	public static void google (WebDriver driver) {
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String gPageTitle = driver.getTitle();
			if (gPageTitle.equals("Google")) {
				System.out.println("Google page title is as expected");
			} else {
				System.out.println("Google page title is not as expected");
			}
	}
	
	public static void form (WebDriver driver) throws InterruptedException {
		
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameField = driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input[@class='form-control ng-untouched ng-pristine ng-invalid']"));
		nameField.sendKeys("Kishan Loriya");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("kishan@patelinc.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test1234");
		WebElement iceCheckBox = driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		iceCheckBox.click();
		
			if (iceCheckBox.isSelected()) {
				System.out.println("Ice Cream Checkbox is checked sucessfully");
			}
			else {
				System.out.println("Ice Cream Checkbox is not yet checked");
			}
		
		WebElement employmentStatus = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		employmentStatus.click();
		
			if(employmentStatus.isSelected()) {
				System.out.println("Employed checkbox is checked sucessfully");
			}
			else {
				System.out.println("Employed checkbox is not yet checked");
			}
		WebElement dateOfBirth = driver.findElement(By.xpath("//label[text()='Date of Birth']/following-sibling::input"));
		dateOfBirth.sendKeys("29021996");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).submit();
		Thread.sleep(2000);
		WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String successMsg = success.getText();
		String actSuccessMsg = successMsg.substring(2);
		String expSuccessMsg = "Success! The Form has been submitted successfully!.";
		
			if(actSuccessMsg.equals(expSuccessMsg)) {
				System.out.println("Success message displayed as Expected");
			}
			else {
				System.out.println("Messgae not expected: " + actSuccessMsg);
			}
			System.out.println("Success Message: " + actSuccessMsg);
	}

}
