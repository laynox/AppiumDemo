import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class apidemo {

    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","xxx");
        capabilities.setCapability("appPackage","io.appium.android.apis");
        capabilities.setCapability("appActivity", ".ApiDemos");
        capabilities.setCapability("automationName","uiautomator2");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }

    @Test
    public void testToast() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Dimension screenSize=driver.manage().window().getSize();

        driver.findElementByAccessibilityId("Views").click();
        Thread.sleep(2000);
        (new TouchAction(driver))
                .press( (int)(screenSize.width*0.5), (int)(screenSize.height*0.9))
                .waitAction(Duration.ofSeconds(1))
                .moveTo((int)(screenSize.width*0.5), (int)(screenSize.height*0.1))
                .release()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Popup Menu']"))).click();
        driver.findElementByAccessibilityId("Make a Popup!").click();
        //locate("//*[contains(@text, 'MAKE')]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[contains(@text,'Search')]").click();

        String toastXPath="//*[@class='android.widget.Toast']";
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))));
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))).getText());
        System.out.println(driver.findElementByXPath(toastXPath).getText());
        //System.out.println(locate(toastXPath).getText());
        for(int i =0;i <10;i++){
            int size=driver.findElementsByXPath(toastXPath).size();
            System.out.println(size);
            Thread.sleep(500);
        }
    }

    @Test
    public void testRoll() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Dimension screenSize=driver.manage().window().getSize();

        driver.findElementByAccessibilityId("Views").click();
        Thread.sleep(2000);
        (new TouchAction(driver))
                .press((int)(screenSize.width * 0.5), (int)(screenSize.height * 0.9))
                .waitAction(Duration.ofSeconds(1))
                .moveTo((int)(screenSize.width*0.5), (int)(screenSize.height*0.1))
                .release()
                .perform();
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Popup Menu']"))).click();
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Seek Bar']"))).click();
        Thread.sleep(5000);
    }

    @Test
    public void webview() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = driver.findElement(By.id("android:id/list"));
      //  AndroidElement list = driver.findElementById("android:id/List");
        MobileElement webtest = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"WebView\"));"));
        webtest.click();
        System.out.println(driver.getContextHandles());
        Thread.sleep(10000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
