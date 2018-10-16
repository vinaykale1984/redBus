package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HotelPage extends BasePage {
 
    //*********Constructor*********
    public HotelPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
  //*********Page Variables*********
    
    private String HotelNavLink = "//a [@href = 'https://www.redbus.in/hotels/']";
    private String HotelActual = "//button[@name= 'search_hotel']";
    private String HotelExpected = "Search";
    private String EnterCityHotelArea = "//div[@class = 'search-form clearfix']/div/label/input[@id = 'search_key']";
    private String Source = "search_key";
    private String CityName = "Goa";
    private String SourceDropdown = "//small[@class ='location'][contains (., 'Goa,India')]";
    private String calendarTable = "//table[@class='rb-monthTable first last']//td";
    private String CalendarCheckInClick = "//input[@name ='checkin_date']";
    private String CalendarCheckOutClick = "//input[@name ='checkout_date']";
    private String GuestRoom = "//input[@name ='guest_count']";
    private String RoomSelect = "//div[@class ='ilbl selectbox a control']/select";
    private String AdultRoom = "//div[@class ='ilbl selectbox undefined']/label[contains(., 'Adults')]";
    private String ChildrenRoom = "//div[@class ='ilbl selectbox undefined']/label[contains(., 'Children')]";
    private String ChildrenAge = "//div[@class ='ilbl selectbox']/label[contains(., 'Child 1 Age')]";
    private String SearchBtn = "//button[@name = 'search_hotel']";
    private String SearchHotelActual = "//div[@class = 'compare-btn']";
    private String SearchHotelExpected = "compare";
    
    
    
    
//Navigating to Hotel page
    
    public void NavigatingToHotelPage() throws Exception {
    	Homepage GotoRedBus = new Homepage(driver, wait);
		GotoRedBus.goToRedBus();
		clickByXpath(HotelNavLink);
		Assert.assertEquals(HotelExpected, readText(By.xpath(HotelActual)));
    }
    
    public void SearchByCityName() throws Exception {
//    	clickByXpath(EnterCityHotelArea);
    	EnterHotelOrCityName(Source, CityName);
    	clickByXpath(CalendarCheckInClick);
    	SelectDate(calendarTable, "15");
    	clickByXpath(CalendarCheckOutClick);
    	SelectDate(calendarTable, "25");
//    	clickByXpath(GuestRoom);
    	System.out.println(1);
    	SelectRoomDropdown(RoomSelect, ChildrenRoom, ChildrenAge);
    	clickByXpath(SearchBtn);
    	Thread.sleep(1000);
    	Assert.assertEquals(SearchHotelExpected, readText(By.xpath(SearchHotelActual)));
    }
  

}
