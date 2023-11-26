package Selenium.EcommerceWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EcommerceAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		String actTitle = driver.getTitle();
		String expTitle = "Google";
		
				if(actTitle.equals(expTitle)) {
					System.out.println("Title is matching with Expected title");
				}
				else {
					System.out.println("Titles are not matching");
				}
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(5000);
		WebElement nameTb = driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input[@class='form-control ng-untouched ng-pristine ng-invalid']"));
		nameTb.sendKeys("Kishan Loriya");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("kishan@patelinc.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("        ");
		WebElement iceCheckBox = driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		iceCheckBox.click();
		
				if(iceCheckBox.isSelected()) {
					System.out.println("Checkbox is checked sucessfully");
				}
				else {
					System.out.println("Checkbox is not yet checked");
				}
		WebElement employmentStatus = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		employmentStatus.click();
		
				if(employmentStatus.isSelected()) {
					System.out.println("Checkbox is checked sucessfully");
				}
				else {
					System.out.println("Checkbox is not yet checked");
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
		driver.quit();
	}
	



}