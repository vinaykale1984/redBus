package test;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public ExtentReports extent;
    public ExtentTest logger;
    
    public WebDriver getDriver() {
        return driver;
    }
 
    @BeforeClass
    public void setup () {
    	File file = new File("D:\\VinayAutomation\\Selenium\\Drivers\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");    	
    	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    	//Create a Chrome driver. All test and page classes use this driver.
        driver = new ChromeDriver(options);
        WebDriver driver =new ChromeDriver(options);
 
//    	File file = new File("D:\\VinayAutomation\\Selenium\\Drivers\\geckodriver.exe");
//    	System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
//    	//Create a Chrome driver. All test and page classes use this driver.
//        driver = new FirefoxDriver();
// 
    	
        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver,10);
 
        //Maximize Window
        driver.manage().window().maximize(); 
        
        extent = new ExtentReports (System.getProperty("user.dir") +"\\ExtentReports\\STMExtentReport.html", true);
                 extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        logger=extent.startTest("Hello");
    }
    
    @BeforeTest
    public void startReport(){
     extent = new ExtentReports (System.getProperty("user.dir") +"/ExtentReports/STMExtentReport.html", true);
       
                   extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }
    
    @AfterTest
    public void getResult(ITestResult result){
//    if(result.getStatus() == ITestResult.SUCCESS){
//    logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
//    }
//    else if(result.getStatus() == ITestResult.FAILURE){
//    logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//    logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
//    }

//    extent.endTest(logger);
//    extent.flush();
//    extent.close();

    
    }
    
    @AfterClass
    public void endReport(){
    	
    			extent.endTest(logger);
                   extent.flush();
                   extent.close();
                   driver.quit();
       }
     
//    @AfterClass
//    public void teardown () {
//        driver.quit();
//    }
}