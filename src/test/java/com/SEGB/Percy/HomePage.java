package com.SEGB.Percy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.percy.selenium.Percy;

public class HomePage {
	
	private static Percy percy;
	@Test
	
	public void homepage() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		
		percy = new Percy(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		//Accepting the cookie pop up
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		//To check if the Logo is present
		
		WebElement Logo = driver.findElement(By.xpath("//img[@id='segb-logo']"));
		
		if (Logo.isDisplayed() && Logo.isEnabled())
		{
			
		File file =	Logo.getScreenshotAs(OutputType.FILE);
		
		File destination_of_screenshotFile = new File("./Screenshots/Logo.png");
	
		//FileUtils.copyFile(file, new File("Logo.png"));
		
		FileUtils.copyFile(file, destination_of_screenshotFile);
			
			System.out.println("The Logo is displayed");
			Thread.sleep(5000);
			percy.snapshot("Logo");
			
			
		}
		
		else
		{
			System.out.println("The Logo is not displayed");
		}
		
		driver.close();
		

	}





		
	}


