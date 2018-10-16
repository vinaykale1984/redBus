package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupportOptions extends Homepage {
	 
    //*********Constructor*********
    public SupportOptions (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
 
    private String WriteToUs = "//*[@id='chat-with-us-option']";
    private String expectedWriteToText = "Write To Us";
    private String CallUs = "//*[@id='call-us-at-option']";
    private String expectedCallUsText = "Call Us At";
    
    
  	public void supportArrow () {
  		WebElement SupportOpionArrow = driver.findElement(By.xpath("//*[@id='support-options']/div"));
  		SupportOpionArrow.click();
  		Assert.assertEquals(readText(By.xpath(WriteToUs)), expectedWriteToText);
  		Assert.assertEquals(readText(By.xpath(CallUs)), expectedCallUsText);
  		System.out.println("Support options are displayed properly");
  	}
  	}