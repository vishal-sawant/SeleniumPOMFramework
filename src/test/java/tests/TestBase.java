
package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
    	    /*WebDriverManager.edgedriver().setup();
    	    driver = new EdgeDriver();*/
    		System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
    		EdgeOptions options = new EdgeOptions();
    		options.addArguments("--headless=new");  // or fallback to --headless
    		options.addArguments("--disable-gpu");
    		options.addArguments("--no-sandbox");
    		options.addArguments("--disable-dev-shm-usage");
    		options.addArguments("--disable-software-rasterizer");
    		options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");  // Use 64-bit
    	    driver = new EdgeDriver(options);

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
