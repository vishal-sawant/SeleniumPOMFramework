
package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        getDriver().get("https://www.saucedemo.com");
        System.out.println("Running on Thread: "+Thread.currentThread().threadId());
        LoginPage login = new LoginPage(getDriver());
        login.login("visual_user", "secret_sauce");
    }
}
