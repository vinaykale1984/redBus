package test;

import org.testng.annotations.Test;
import pages.GmailPage;

public class gmailLogin extends BaseTest {
	
	//Verify navigating gmail website
	@Test
	public void Verify_navigating_to_Gmail_HomePage() throws Exception{
		
		GmailPage gmail = new GmailPage (driver, wait);
		gmail.goToGmail();
	}
		 
	//Verify the display contents of Gmail homepage

	
	//Verify tapping on next btn without email
	@Test
	public void Verify_tapping_on_next_btn_without_email() {
		
		GmailPage emptyGmail = new GmailPage(driver, wait);
		emptyGmail.emptyEmail();
	}
	
	//Verify tapping on next btn with invalid email
	@Test
	public void Verify_tapping_on_next_btn_with_invalid_email() {
		
		GmailPage invalidGmail = new GmailPage(driver, wait);
		invalidGmail.invalidEmail();
	}

}
