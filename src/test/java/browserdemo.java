import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class browserdemo {

    private AppiumDriver<AndroidElement> driver;

    @Before
    public  void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","xxx");
        capabilities.setCapability("browserName","Browser");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @Test
    public void browsertest() throws InterruptedException {
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
