import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple multiplication test on Android device using Scientific Calculator application.
 * Test multiplies two 1-digit numbers and shows a result of operation.
 * After the multiplication operation it exits from the app.
 * Application installation is described in README.md.
 * Capacities and URL must be adapted:
 * see README.md to find out where to find the specific values for your test on your dashboard.
 * If you want to refer to specific elements of the app (like "ButtonMultiply" in this example),
 * you need to install Appium-Desktop (https://github.com/appium/appium-desktop)
 * and use the Appium inspector to find the element id. The parameters to specify on the Appium-Desktop are the same
 * than those you specify here.
 */

public class Multiplication {
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
    public void testMultiplication() throws Exception {
        MobileElement e10 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button6"));
        e10.click();

        MobileElement e11 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonMultiply"));
        e11.click();

        MobileElement e12 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/Button4"));
        e12.click();

        MobileElement e13 = (MobileElement)
                driver.findElement(By.id("com.scientificCalculator:id/ButtonEqualTo"));
        e13.click();

        Thread.sleep(1500);

        driver.navigate().back();
    }

    public void tearDown() {
        driver.quit();
    }
}
