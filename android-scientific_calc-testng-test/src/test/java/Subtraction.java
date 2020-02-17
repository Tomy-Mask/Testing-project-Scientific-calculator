import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple subtraction test on Android device using Scientific Calculator application.
 * Test subtracts a 1-digit number from a 2-digit number and shows a result of operation.
 * After the subtraction operation it exits from the app.
 * Application installation is described in README.md.
 * Capacities and URL must be adapted:
 * see README.md to find out where to find the specific values for your test on your dashboard.
 * If you want to refer to specific elements of the app (like "ButtonSubtract" in this example),
 * you need to install Appium-Desktop (https://github.com/appium/appium-desktop)
 * and use the Appium inspector to find the element id. The parameters to specify on the Appium-Desktop are the same
 * than those you specify here.
 */

public class Subtraction {
    AndroidDriver driver;

    @BeforeClass()
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        /* These are the capabilities we must provide to run our test */
        capabilities.setCapability("app", "PASTE_PATH_TO_APP\\APP_NAME.apk");
        capabilities.setCapability("VERSION", "PASTE_VERSION");
        capabilities.setCapability("deviceName", "PASTE_DEVICE_NAME");
        capabilities.setCapability("platformName", "PASTE_PLATFORM_NAME");

        /* REMOTE_HOST; REMOTE_PORT; REMOTE PATH  can be found under Custom Server tab in Appium Desktop  */
        driver = new AndroidDriver(new URL("http://REMOTE_HOST:REMOTE_PORT/REMOTE_PATH"), capabilities);

    }

    @Test
    public void testSubtraction() throws Exception {

        /* These elements are resource-ids and can be found with Appium Inspector. They can easily be changed.*/
        MobileElement e5 = (MobileElement)
                driver.findElement(By.id("PASTE_RESOURCE-ID_OF_NUMBER"));
        e5.click();

        MobileElement e6 = (MobileElement)
                driver.findElement(By.id("PASTE_RESOURCE-ID_OF_NUMBER"));
        e6.click();

        MobileElement e7 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonSubtract"));
        e7.click();

        MobileElement e8 = (MobileElement)
                driver.findElement(By.id("PASTE_RESOURCE-ID_OF_NUMBER"));
        e8.click();

        MobileElement e9 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonEqualTo"));
        e9.click();

        Thread.sleep(1500);

        driver.navigate().back();
    }

    public void tearDown() {
        driver.quit();
    }
}
