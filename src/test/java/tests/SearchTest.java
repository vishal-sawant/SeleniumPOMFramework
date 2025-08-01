
package tests;

import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends TestBase {

    @Test
    public void testSearch() {
        driver.get("https://www.google.com");
        SearchPage search = new SearchPage(driver);
        search.search("Selenium TestNG Parallel");
    }
}
