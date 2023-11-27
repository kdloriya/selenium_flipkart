package KishanPractice.ProjectOne;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;


public class ProjectOne 
{ 
	static WebDriver driver;
	
    public static void main (String [] args) throws InterruptedException{
    	
    	ChromeOptions option = new ChromeOptions();
    	option.addArguments("incognito");
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		macAir(driver);
		
    }
    
    public static void macAir (WebDriver driver) throws InterruptedException {
		
    	driver.manage().window().maximize();
    	driver.get("https://www.flipkart.com/");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[@class='JFPqaw']/span")).click();
    	driver.findElement(By.className("Pke_EE")).sendKeys("macbook air m2");
    	driver.findElement(By.className("Pke_EE")).sendKeys(Keys.ENTER);
    	Thread.sleep(3000);
    	String totalProducts = driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText();
    	System.out.println(totalProducts);
    	String currentWinHandle = driver.getWindowHandle();
    	driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//div/div[@class='_2kHMtA'])[1]")).click();
	    Thread.sleep(5000);
		Set <String> allWinHandle = driver.getWindowHandles(); 
		String newWinHandle = null;
			for (String winHandle : allWinHandle) { 
			 if (!winHandle.equals(currentWinHandle)) {
				newWinHandle = winHandle;
			 	 break;
			 	 }
			 }
		driver.switchTo().window(newWinHandle);
    	String prodPrice = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
    	String prodDiscount = driver.findElement(By.xpath("//div[@class='_3Ay6Sb _31Dcoz']")).getText();
    	System.out.println("Your Product is available at: " + prodPrice + " with " + prodDiscount);
    	Thread.sleep(3000);
    	WebElement readMoreBtn = driver.findElement(By.xpath("//button[text()='Read More']"));	
      	WebElement specs = driver.findElement(By.xpath("//div[text()='Specifications']"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", specs); 
    	readMoreBtn.click();
    	String capacity = driver.findElement(By.xpath("//td[text()='SSD Capacity']/parent::tr//following-sibling::td//li")).getText();
	    	if (capacity.contains("512 GB")) {
	    		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	    		System.out.println("Product added to cart");
	    		driver.findElement(By.xpath("//span[text()='Cart']")).click();
	    		Thread.sleep(3000);
				String cartTotal = driver.findElement(By.xpath("//div[text()='Total Amount']/parent::div/following-sibling::div")).getText();
				System.out.println("Total Cart value is " + cartTotal);
				WebElement placeOrderBtn = driver.findElement(By.xpath("//button/span[text()='Place Order']"));
				placeOrderBtn.click();		    				
				String loginPageTitle = driver.getTitle();
				Thread.sleep(2000);
					if (loginPageTitle.contains("Login")) {
						System.out.println("Flow Complete");
						driver.quit();
	    			} else {
	    					System.out.println("Final Login page is not opened");
	    				}
	    	} else {
	    		System.out.println("The product is not matching the requirements");
	    }
	  }
	}

