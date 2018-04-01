import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.MainActivity;

import java.net.URL;

public class xueqiupagedemo {

    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "ddd");
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void mainpage() throws InterruptedException {
        MainActivity mian = new MainActivity();
        PageFactory.initElements(driver,mian);


        mian.click行情();


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
