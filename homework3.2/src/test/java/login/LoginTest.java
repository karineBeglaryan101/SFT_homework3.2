package login;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.Login;

public class LoginTest extends BaseTest {

    @Test
    public void testUnSuccessfulSignIn(){
        Login signInPage = homePage.clickSignIn();
        String message =  signInPage.error("aaa");
        Assert.assertTrue(message.contains("We cannot find an account with that email address"));
    }

    @Test
    public void testSuccessfulSignIn(){
        Login signInPage = homePage.clickSignIn();
        String message = signInPage.sLogin("mb309970@gmail.com", "2=&d/JUA2*EMkNq");
        Assert.assertTrue(message.contains("Signed in"));
    }


}
