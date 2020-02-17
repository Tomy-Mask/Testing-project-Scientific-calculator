import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple division test on Android device using Scientific Calculator application.
 * Test divides 1-digit number from a 3-digit number and shows a result of operation.
 * After the division operation it exits from the app.
 * Application installation is described in README.md.
 * Capacities and URL must be adapted:
 * see README.md to find out where to find the specific values for your test on your dashboard.
 * If you want to refer to specific elements of the app (like "ButtonDivide" in this example),
 * you need to install Appium-Desktop (https://github.com/appium/appium-desktop)
 * and use the Appium inspector to find the element id. The parameters to specify on the Appium-Desktop are the same
 * than those you specify here.
 */

public class Division {
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
    public void testDivision() throws Exception {
        MobileElement e14 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button1"));
        e14.click();

        MobileElement e15 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button2"));
        e15.click();

        MobileElement e16 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button0"));
        e16.click();

        MobileElement e17 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonDivide"));
        e17.click();

        MobileElement e18 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button5"));
        e18.click();

        MobileElement e19 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonEqualTo"));
        e19.click();

        Thread.sleep(1500);

        driver.navigate().back();
    }

    public void tearDown() {
        driver.quit();
    }
}
