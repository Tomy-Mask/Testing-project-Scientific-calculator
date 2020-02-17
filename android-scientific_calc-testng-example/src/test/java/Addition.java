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
        capabilities.setCapability("app", "E:\\Calculator\\Scientific_Calculator.apk");
        capabilities.setCapability("VERSION", "9,0");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testAddition() throws Exception {
        MobileElement e1 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button2"));
        e1.click();

        MobileElement e2 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonAdd"));
        e2.click();

        MobileElement e3 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button6"));
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
