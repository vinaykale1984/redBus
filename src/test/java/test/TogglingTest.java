package test;

import org.testng.annotations.Test;
import pages.TogglingPage;

public class TogglingTest extends BaseTest {
	
	//Verify sorting departure in ascending order
	@Test
	public void Verify_sorting_departure_in_ascending_order() throws Exception{
		TogglingPage DepartureAscSort = new TogglingPage(driver, wait);
		DepartureAscSort.DepartureSortAscending();
	}
	
	//Verify sorting departure in descending order
	@Test
	public void Verify_sorting_departure_in_descending_order() throws Exception{
		TogglingPage DepartureDescSort = new TogglingPage(driver, wait);
		DepartureDescSort.DepartureSortDescending();
	}
	
	//Verify sorting duration in descending order
	@Test
	public void Verify_sorting_duration_in_descending_order() throws Exception{
		TogglingPage DurationDescSort = new TogglingPage(driver, wait);
		DurationDescSort.DurationSortDescending();
	}
	
	//Verify sorting duration in Ascending order
	@Test
	public void Verify_sorting_duration_in_ascending_order() throws Exception{
		TogglingPage DurationAscSort = new TogglingPage(driver, wait);
		DurationAscSort.DurationSortAscending();
	}
	

	
	
}