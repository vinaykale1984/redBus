package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GmailPage extends BasePage {
 
    //*********Constructor*********
    public GmailPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    
  //*********Page Variables*********
    
    private String baseURL = "https://www.google.com/intl/en-GB/gmail/about/#";
    private String pageIsDisplayed = "/html/body/main/section/div[2]/div[2]/h1";
    private String expectedText = "The ease & simplicity of Gmail, available across devices";
    private String SigninBtn = "/html/body/nav/div/a[2]";
    private String EmailNextBtn = "//*[@id='identifierNext']/content/span";
    private String EmailErrorText = "//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]";
    private String ExpectedEmailError = "Enter an email or phone number";
//    private String EmailTextField = "//div[@class='aCsJod oJeWuf']/div/div/input[@id='identifierId']";
    private String EmailTextField = "//*[@id='identifierId']";
    
    
    //*********Page Methods*********
    
    //Go to Homepage
  	public void goToGmail() {
  		driver.get(baseURL);
        driver.navigate().to(baseURL);
        Assert.assertEquals(readText(By.xpath(pageIsDisplayed)), expectedText);
  	}

  	public void emptyEmail () {
  		clickByXpath(SigninBtn);
  		clickByXpath(EmailNextBtn);
  		Assert.assertEquals(readText(By.xpath(EmailErrorText)), ExpectedEmailError);
  		
  	}
  	
  	public void invalidEmail() {
  		
//  		clickByXpath(EmailTextField);
  		writeText(By.xpath(EmailTextField), "123shufukh");
  		clickByXpath(EmailNextBtn);
  		Assert.assertEquals(readText(By.xpath(EmailErrorText)), ExpectedEmailError);
  	}
  	
}
