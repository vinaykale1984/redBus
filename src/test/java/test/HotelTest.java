package test;

import org.testng.annotations.Test;
import pages.HotelPage;


public class HotelTest extends BaseTest {
	
	//Verify navigating to Hotel result page
	@Test
	public void Verify_navigating_to_Hotel_result_page() throws Exception{
		HotelPage HotelPageNav = new HotelPage(driver, wait);
		HotelPageNav.NavigatingToHotelPage();
	}
	
	//Verify searching of Hotels in Goa
	@Test
	public void Verify_searching_of_Hotels_in_Goa() throws Exception {
		HotelPage RoomSelect = new HotelPage(driver, wait);
		RoomSelect.SearchByCityName();
		
	}
}
