
package tests;

import org.testng.annotations.Test;
import pages.ProfilePage;
import org.testng.Assert;

public class ProfileTest extends TestBase {

    @Test
    public void testProfileTitle() {
        driver.get("https://example.com/profile");
        ProfilePage profile = new ProfilePage(driver);
        Assert.assertTrue(profile.getTitle().contains("Profile"));
    }
}
