package pages.common;

import locators.ItemConstants;
import locators.TodayDealsConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TodayDeals {
    private WebDriver driver;
    private By logo = By.id(TodayDealsConstants.name);
    private By information = By.className(TodayDealsConstants.ids);



    public TodayDeals(WebDriver driver){
        this.driver=driver;
    }

    public String viewLogo(){
        WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(logo));
        return name.getText();
    }

    public boolean deals(){
        List<WebElement> deals = driver.findElements(information);
        return deals.isEmpty();
    }





}
