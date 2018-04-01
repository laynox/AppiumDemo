package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainActivity {

    @FindBy(xpath="//*[@text='自选']")
    public WebElement 自选;

    @FindBy(xpath="//*[@text='行情']")
    public WebElement 行情;

    @FindBy(xpath="//*[@text='美股']")
    public WebElement 美股;

    public void click自选(){
     自选.click();
     }

    public void click行情() throws InterruptedException {
        Thread.sleep(1000);
        行情.click();
    }

    public void click美股(){
        美股.click();
    }
}



