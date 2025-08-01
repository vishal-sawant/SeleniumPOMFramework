
package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    protected WebDriver driver;
    protected static Logger logger = LogManager.getLogger(TestBase.class);
    
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
    	logger.info("Setting up the browser");
    	if (browser.equalsIgnoreCase("edge")) {
    	    //WebDriverManager.edgedriver().setup();
    		System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
    	    driver = new EdgeDriver();
    	}
    	else if (browser.equalsIgnoreCase("chrome")) {
    		driver = new ChromeDriver();
    	}
    	threadDriver.set(driver);
    	getDriver().manage().window().maximize();
    }
    
    protected static WebDriver getDriver() {
    	return threadDriver.get();
    }
    

    @AfterMethod
    public void tearDown() {
        driver.quit();
        threadDriver.remove();
    }
}
