package testsuite;

/*1. UserSholdLoginSuccessfullyWithValidCredentials
        * Enter “tomsmith” username
        * Enter “SuperSecretPassword!” password
        * Click on ‘LOGIN’ button
        * Verify the text “Secure Area”
        2. verifyTheUsernameErrorMessage
        * Enter “tomsmith1” username
        * Enter “SuperSecretPassword!” password
        * Click on ‘LOGIN’ button
        * Verify the error message “Your username
        is invalid!”
        3. verifyThePasswordErrorMessage
        * Enter “tomsmith” username
        * Enter “SuperSecretPassword” password
        * Click on ‘LOGIN’ button
        * Verify the error message “Your password
        is invalid!”*/

import browsfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {

        //Enter username and password
        sendTextToElement(By.name("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");

        //click on login button
        clickElement(By.xpath("//button[@type='submit']"));

    }

    @Test
    public void VerifytheerrormessageYourusernameisinvalid() {
        //Enter username and password
        sendTextToElement(By.name("username"), "tomsmith");
        sendTextToElement(By.name("password"), "SuperSecretPassword");

        //click on login button
        clickElement(By.xpath("//button[@type='submit']"));
        String expectedmessage = "Your password is invalid!";
        String actualmessage = getTextFromElement(By.xpath("//*[@id=\"flash-messages\"]"));
        Assert.assertEquals("passworInvalid", actualmessage, expectedmessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        sendTextToElement(By.id("username"), "tomsmith1");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickElement(By.xpath("//*[@id=\"flash\"]"));
        String actualmessage = "Your username is invalid!";
        Assert.assertEquals(actualmessage,"Your username is invalid");
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickElement(By.xpath("//*[@id=\"flash\"]"));
        String expectedmessage = "Your password is invalid!";
        Assert.assertEquals(expectedmessage,"Your password is invalid");
    }

}