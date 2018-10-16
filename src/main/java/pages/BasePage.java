package pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.emory.mathcs.backport.java.util.Collections;
import junit.framework.Assert;
 
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
 
    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
 
    //Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
    
    //Click by Xpath
    public void clickByXpath (String element) {
    	driver.findElement(By.xpath(element)).click();
    }

  public void SelectDate (String element, String num){
	  List<WebElement> allDates=driver.findElements(By.xpath(element));
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase(num))
			{
				ele.click();
				break;
			}
		}
  }
  
  
    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
    
    //SendText By id
    public void SendTextById (String Id, String text) {
    	driver.findElement(By.id(Id)).sendKeys(text);
    }
    
    
    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
    
    //web driver wait by xpath
    public void waitPresenceOfElement(String element){
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));   /*examining the xpath for a search     
        box*/
       
    }
    
    public void AutoFillCityName (String cityID, String cityText, String autoFillXpath) throws Exception{
    	WebElement city= driver.findElement(By.id(cityID));
	      city.clear();
	      city.sendKeys(cityText);
	      Thread.sleep(3000);
	      Actions builder=new Actions(driver);
	      builder.moveToElement( city.findElement(By.xpath(autoFillXpath))).click().build().perform();
    }
    
    public void EnterHotelOrCityName (String cityID, String cityText) throws Exception{
    	WebElement city= driver.findElement(By.id(cityID));
	      city.clear();
	      city.sendKeys(cityText);
	      Thread.sleep(3000);
    }
    
    public void spanSelect (String cityID, String CitySelect) throws Exception {
    	
    	 Thread.sleep(3000);
    	WebElement city= driver.findElement(By.id(cityID));
	      Thread.sleep(3000);
	      Actions builder=new Actions(driver);
	      builder.moveToElement( city.findElement(By.xpath(CitySelect))).click().build().perform();
	      Thread.sleep(3000);
    }
  
    public void ListAllElements(String TravelElement, String AgentName, String Prices ) throws ParseException, InterruptedException {
    	
      	 List<WebElement> TravelsName= driver.findElements(By.xpath(TravelElement));
      	 System.out.println(TravelsName);
      	 List<WebElement> priceList = driver.findElements(By.xpath(Prices));
      	 List<Double> list=new ArrayList<Double>();

      	 for(WebElement Name : TravelsName )
      	 {
      		 String CompleteTravelsName =Name.getText();
      		 System.out.println(CompleteTravelsName);
      			 if(CompleteTravelsName.toLowerCase().contains(AgentName.toLowerCase())) {
      		 
      		 for (WebElement LeastPrice : priceList)
      		 {
      			String price = LeastPrice.getText();
      			list.add(Double.parseDouble(price));
      			System.out.println(list);
      			break;
      		 }
      		
      		 }
      	 }
//      	 System.out.println(list);
      		Collections.sort(list);
//      		System.out.println(list);
//      		System.out.println("Least price is :" +list.get(0));
      		Double lFare = list.get(0);
            String lowestFare = String.valueOf(lFare);
//            int loweFare = Integer.parseInt(lFare);
            int loweFare = lFare.intValue();
            
            DateFormat df = new SimpleDateFormat("h:mm a");
            Date time = null;
            int index = 0;
            Date TenT = null;
            String ten = "23:45 PM";
            TenT = df.parse(ten);
            
            driver.findElement(By.xpath("//span[text()= "+loweFare+"]/../../../../../../div/div/div/following-sibling::div/div[@class ='dp-time f-19 d-color f-bold'][contains(., '23:45')]/../../../../div/following-sibling::div/div[@class ='button view-seats fr']")).click();
      		Thread.sleep(3000);
      	 }

    
   
    
    
    public void SortList( String element ) {
    	List<WebElement> elementName = driver.findElements(By.xpath(element));
     	 List<String> Unsortedlist=new ArrayList<String>();
     	 
     	 for(WebElement ElementList : elementName)
     	 {
     		String CompleteElementList = ElementList.getText();
     		Unsortedlist.add(CompleteElementList);
//  			System.out.println("ascending");
  			
     	 }
    
     	List SortedList = new ArrayList(Unsortedlist);
     	Collections.sort(Unsortedlist);
     	Assert.assertEquals(Unsortedlist, SortedList );
    }
    
    
    public void SortListDesc( String element ) {
    	List<WebElement> elementName = driver.findElements(By.xpath(element));
     	 List<String> Unsortedlist=new ArrayList<String>();
     	 
     	 for(WebElement ElementList : elementName)
     	 {
     		String CompleteElementList = ElementList.getText();
     		Unsortedlist.add(CompleteElementList);
//  			System.out.println("Descending");
  			
     	 }
    
     	List SortedList = new ArrayList(Unsortedlist);
     	Collections.sort(Unsortedlist, Collections.reverseOrder());
     	Assert.assertEquals(Unsortedlist, SortedList );
    }
    
    public void SelectRoomDropdown (String element, String ChildrenElement, String ChildrenAgeElement) {
    	Select dropdown = new Select(driver.findElement(By.xpath(element)));
    	dropdown.selectByIndex(2);
    	WebElement option = dropdown.getFirstSelectedOption();
    	int num = Integer.parseInt(option.getText());
    	for(int i=1; i <= num; i++)
    	{
    		Select Adultdropdown = new Select(driver.findElement(By.xpath("//div[text()='Room "+i+"']/following-sibling::div/label[text() ='Adults']/following-sibling::select")));
    		Adultdropdown.selectByIndex(2);
    		Select Childrendropdown = new Select(driver.findElement(By.xpath("//div[text()='Room "+i+"']/following-sibling::div/following-sibling::div/label[text() ='Children']/following-sibling::select")));
    		Childrendropdown.selectByIndex(1);
    		
    		WebElement Childoption = Childrendropdown.getFirstSelectedOption();
    		int Childnum = Integer.parseInt(Childoption.getText());
    		for(int j=1; j <= Childnum; j++)
    		{
    			Select ChildrenAgedropdown = new Select(driver.findElement(By.xpath("//div[text()='Room "+i+"']/following-sibling::div/following-sibling::div/following-sibling::div/label[text() ='Child "+j+" Age']/following-sibling::select")));
    			ChildrenAgedropdown.selectByIndex(1);
    		}
    		
    	}
    	 
    }

   			
     }
    

    


