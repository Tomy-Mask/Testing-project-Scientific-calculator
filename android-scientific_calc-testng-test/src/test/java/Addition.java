import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple addition test on Android device using Scientific Calculator application.
 * Test adds two 1-digit numbers and shows a result of operation.
 * After the addition operation it exits from the app.
 * Application installation is described in README.md.
 * Capacities and URL must be adapted:
 * see README.md to find out where to find the specific values for your test on your dashboard.
 * If you want to refer to specific elements of the app (like "ButtonAdd" in this example),
 * you need to install Appium-Desktop (https://github.com/appium/appium-desktop)
 * and use the Appium inspector to find the element id. The parameters to specify on the Appium-Desktop are the same
 * than those you specify here.
 */

public class Addition {
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
    public void testAddition() throws Exception {

        /* These elements are resource-ids and can be found with Appium Inspector. They can easily be changed.*/
        MobileElement e1 = (MobileElement)
                driver.findElement(By.id("PASTE_RESOURCE-ID_OF_NUMBER"));
        e1.click();

        MobileElement e2 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonAdd"));
        e2.click();

        MobileElement e3 = (MobileElement)
                driver.findElement(By.id("PASTE_RESOURCE-ID_OF_NUMBER"));
        e3.click();

        MobileElement e4 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonEqualTo"));
        e4.click();

        Thread.sleep(1500);

        driver.navigate().back();
    }

    public void tearDown() {
        driver.quit();
    }
}
