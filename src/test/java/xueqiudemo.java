import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class xueqiudemo {

    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "192.168.56.101:5555");
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


    @Test
    public void sampleTest() throws InterruptedException{
        Thread.sleep(30000);
        AndroidElement ele = driver.findElement(By.id("com.xueqiu.android:id/user_profile_icon"));
        Thread.sleep(4000);
        ele.click();
        Thread.sleep(3000);
    }

    @Test
    public void testWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//*[@text='自选']").click();
    }

    @Test
    public void testWait2(){
        WebDriverWait wait=new WebDriverWait(driver, 10);
        for(int i=0;i<10;i++) {
            System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='自选']"))).getLocation());
        }
        driver.findElementByXPath("//*[@text='自选']").click();
    }

    @Test
    public void testwebview(){
        driver.findElementByXPath("//*[@text='交易']").click();
        System.out.println(driver.getContextHandles());
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
