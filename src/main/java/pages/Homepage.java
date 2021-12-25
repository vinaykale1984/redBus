package pages;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.beust.jcommander.internal.Lists;
import com.google.errorprone.annotations.Var;

import utils.ExtentTestManager;
 
public class Homepage extends BasePage {
 
    //*********Constructor*********
    public Homepage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
 
    //*********Page Variables*********
    private String baseURL = "https://www.redbus.in/";
    private String HomepageDisplayed = "//*[@id='rh_header']/div/div/div[2]/div[3]/div[2]/a";
    private String HomePageexpected = "Help";
    private String source = "src";
//    private String source = "//input[@id = 'src']";
    private String destination = "dest";
    private String Search = "//button[@id= 'search_btn']";
    private String ReturnDate = "//*[@id='return_cal']";
    private String calendarTable = "//table[@class='rb-monthTable first last']//td";
    private String ResultPage = "//span[@class = 'title'][contains(., 'ONWARD JOURNEY')]";
    private String ActualResultPage = "ONWARD JOURNEY";
    private String ModifyBtn = "//*[@id='fixer']/div/div[1]/div[2]/div[2]";
    private String droparrow = "geolocation_chosen";
    private String DropDownCity = "//span[@class = ' geo_dropdown_arrow icon-down icon ich dib']";  // dropdown is shown 
    private String SelectCity = "//div[@id='home-lang']/ul/following-sibling::ul/following-sibling::ul/li/span/span";
    private String Sourcecity = "BENGALURU";
    private String SourceDropdown = "//*[@id='search']/div/div[1]/div/ul/li[1]";
    private String DestinationCity = "HYDERABAD";
    private String DestinationDropdown = "//*[@id='search']/div/div[2]/div/ul/li[1]";
    
    //DropdownSelect page elements
    
    private String DropdownActualPage = "//*[@id='geolocation_chosen']";
    private String DropdownExpectedPage = "Others";
    
    
    //Travels name & least price elements
    
    private String BusName = "//div[@class = 'column-two p-right-10 w-30 fl']";
    private String Agent = "Greenline";
    private String TicketPrice = "//span[@class = 'f-19 f-bold']";
    private String viewSeatActual= "//span[@class = 'seatSelMsg'][contains(., 'Click on an Available seat to proceed with your transaction.')]";
    private String viewSeatExpected  = "Click on an Available seat to proceed with your transaction.";
    //*********Page Methods*********
 
    //Go to Homepage
  	public void goToRedBus() {
  		driver.get(baseURL);
        driver.navigate().to(baseURL);
        Assert.assertEquals(readText(By.xpath(HomepageDisplayed)), HomePageexpected);
        
        
		
	}
  	
  	public void DisplayElements() {
  		
  		List<String> expectedTooltips = Lists.newArrayList("redbus","BUS TICKETS", "HOTELS", "BUS HIRE", "PILGRIMAGES", "CARS Outstation", "Help");
  		   
	    List<WebElement> TopNavigation = driver.findElements(By.xpath("//*[@id='rh_header']/div/div"));
	    List<WebElement> links =TopNavigation.get(0).findElements(By.tagName("a"));
//	    System.out.println(expected.length());
	    
	    boolean areElementsAsExpected = expectedTooltips.equals(links);
	    
//	    for(int j=0; j<links.size(); j++){
//	    	
//	    	String act=links.get(j).getText();
//	    	
//	    	assertTrue(act.length() == expected.length() && act.contains(expected) && expected.contains(act));
//	    	
//	    	if(act.equalsIgnoreCase(exp[j]))
//	    	{
//	    		
//	    		System.out.println("element  macth"+act+"expected"+exp[j]);
//	    	}
//	    	else
//	    	{
//	    		System.out.println("element not macth"+act+"expected"+exp[j]);
//	    	}
	    	
//	    }
	}
  	
  	
	public void DropdownSelect() throws Exception {
		
		spanSelect(droparrow, DropDownCity );
		clickByXpath(SelectCity);
		Thread.sleep(3000);
		Assert.assertEquals(readText(By.xpath(DropdownActualPage)), DropdownExpectedPage);
	}
  	
  	public void SearchBus() throws Exception {
  				
  		AutoFillCityName(source, Sourcecity, SourceDropdown );
  		AutoFillCityName(destination, DestinationCity, DestinationDropdown );
  		
//  		SendTextById(source, Sourcecity);
//  		SendTextById(destination, DestinationCity);
  		
		driver.findElement(By.xpath("//*[@id='search']/div/div[3]/div/label")).click();
  		SelectDate(calendarTable, "15");
  		driver.findElement(By.xpath("//*[@id='search']/div/div[4]/div/label")).click();
  		SelectDate(calendarTable, "20");
  		clickByXpath(Search);		
  		Assert.assertEquals(readText(By.xpath(ResultPage)), ActualResultPage);
 
	}
  	
  	public void BookLeastPriceBus() throws ParseException, InterruptedException {
  		ListAllElements(BusName, Agent, TicketPrice);
  		Assert.assertEquals(readText(By.xpath(viewSeatActual)), viewSeatExpected);
  		Assert.assertEquals(readText(By.xpath(viewSeatActual)), viewSeatExpected);
  	}
  	
  	}	
    
