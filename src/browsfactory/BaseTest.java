package browsfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseurl){

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver =new ChromeDriver();
        //launch the URL
        driver.get(baseurl);
        //Maximize Window
        driver.manage().window().maximize();
        //we give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void clickElement(By by) {
        WebElement loginlink = driver.findElement(by);
        loginlink.click();
    }
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }


    public void closeBrowser(){
        driver.quit();
    }

}

