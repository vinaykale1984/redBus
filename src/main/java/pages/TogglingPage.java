package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.LoginTest;
import pages.Homepage;

public class TogglingPage extends BasePage {
 
    //*********Constructor*********
    public TogglingPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //*********Page Variables*********
    
    private String DepartureBtn = "//div[@class = 'w-10 fl f-12 d-color'][contains(., 'Departure')]"; //w-10 fl f-12 d-color
    private String DepartureTime = "//div[@class = 'dp-time f-19 d-color f-bold']";
    private String SelectedDepartureBtn = "//div[@class = 'w-10 fl f-12 d-color selected'][contains(., 'Departure')]"; //w-10 fl f-12 d-color selected
    private String DurationBtn = "//div[@class = 'w-10 fl f-12 d-color'][contains(., 'Duration')]";
    private String SelectedDurationBtn = "//div[@class = 'w-10 fl f-12 d-color selected'][contains(., 'Duration')]";
    private String DurationTime = "//div[@class = 'dur l-color lh-24']";
    
   
  
    //Sorting Departure in ascending
    
    public void DepartureSortAscending() throws Exception {
    	Homepage GotoRedBus = new Homepage(driver, wait);
		GotoRedBus.goToRedBus();    	
    	Homepage search = new Homepage(driver, wait);
		search.SearchBus();
		clickByXpath(DepartureBtn);
		SortList(DepartureTime);
		
    	
    }
    
    public void DepartureSortDescending() {
    	clickByXpath(SelectedDepartureBtn);
    	SortListDesc(DepartureTime);
    }
    
    public void DurationSortAscending() {
    	clickByXpath(DurationBtn);
    	SortListDesc(DurationTime);
    }
    
    public void DurationSortDescending () {
    	clickByXpath(SelectedDurationBtn);
    	SortList(DurationTime);
    }
    
    
}
