package test;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Homepage;
import pages.SupportOptions;
import utils.ExtentTestManager;




public class LoginTest extends BaseTest {
	
	//Verify navigating from splashscreen to homepage
	@Test(priority = 1)
	public void Verify_navigating_from_RedBusPage() throws Exception{
		
		Homepage GotoRedBus = new Homepage(driver, wait);
		GotoRedBus.goToRedBus();
	}
	
	//Verify the display contents on the redbus homepage
	
	@Test(priority = 2)
	public void Verify_the_display_contents_on_the_redbus_homepage() {
		try {
			Homepage displaycontents = new Homepage(driver, wait);
			displaycontents.DisplayElements();
			logger.log(LogStatus.PASS, "Verify the display contents on the redbus homepage");
			System.out.println("Logger check");
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Display contents are not matching");
		}
		
		
	}
	
	
	//verify selecting a city of user choice from the dropdown
	
	@Test(priority = 3)
	public void Verify_selecting_a_city_of_user_choice_from_the_dropdown() throws Exception {
		
		try {
		Homepage dropdownCity = new Homepage(driver, wait);
		dropdownCity.DropdownSelect();
		logger.log(LogStatus.PASS, "City of user choice is selected");
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "City of user choice is not selected");
		}
	}
	
	
	@Test(priority = 4)
	public void Verify_searching_of_bus_from_blr_hyd() throws Exception {
		Homepage search = new Homepage(driver, wait);
		search.SearchBus();
	}
	
	@Test(priority = 5)
	public void Verify_booking_of_least_price_bus_ticket() throws ParseException, InterruptedException {
		Homepage book = new Homepage(driver, wait);
		book.BookLeastPriceBus();
	}
	

	}

