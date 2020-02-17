import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple test on Android device using Scientific Calculator application.
 * Test shows a value of π(pi) and exits from the app.
 * Application installation is described in README.md.
 * Capacities and URL must be adapted:
 * see README.md to find out where to find the specific values for your test on your dashboard.
 * If you want to refer to specific elements of the app (like "ButtonShift" in this example),
 * you need to install Appium-Desktop (https://github.com/appium/appium-desktop)
 * and use the Appium inspector to find the element id. The parameters to specify on the Appium-Desktop are the same
 * than those you specify here.
 */

public class ValueOfPi {
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
    public void testValueOfPi() throws Exception {
        MobileElement e20 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonShift"));
        e20.click();

        MobileElement e21 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonAdd"));
        e21.click();

        MobileElement e22 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonEqualTo"));
        e22.click();

        Thread.sleep(1500);

        driver.navigate().back();
    }

    public void tearDown() {
        driver.quit();
    }
}
