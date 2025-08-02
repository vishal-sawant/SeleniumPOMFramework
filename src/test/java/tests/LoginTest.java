
package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    @SuppressWarnings("deprecation")
	@Test
    public void testLogin() {
        getDriver().get("https://www.saucedemo.com");
        System.out.println("Running on Thread: "+Thread.currentThread().getId());
        LoginPage login = new LoginPage(getDriver());
        login.login("visual_user", "secret_sauce");
    }
}
