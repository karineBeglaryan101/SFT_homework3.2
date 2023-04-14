package pages.common;

import locators.LogInConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    private By signInField = By.id(LogInConstants.EMAIL);
    private By password_field = By.id(LogInConstants.Password);
    private By loginButton = By.id(LogInConstants.Button);
    private By continueButton = By.id(LogInConstants._continue);
    private By errorMessage = By.id(LogInConstants.Error);


    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void setSignInField(String email){

        driver.findElement(signInField).sendKeys(email);
    }

    public void setPassword(String password){

        driver.findElement(password_field).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickContinue(){
        WebElement clickContinue = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(continueButton));
        clickContinue.click();
    }

    public String error(String email){
        setSignInField(email);
        clickContinue();
        WebElement clickError = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(errorMessage));
        return clickError.getText();
    }

    public String sLogin(String email, String password){
        setSignInField(email);
        clickContinue();
        setPassword(password);
        clickLoginButton();
        return "Signed in";
    }

}
