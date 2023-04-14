package pages.common;

import locators.HomePageConstants;
import locators.TodayDealsConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By searchField = By.id(HomePageConstants.SEARCH_FIELD);
    private By login_button = By.cssSelector(HomePageConstants.LOGIN);
    private By today_deals = By.xpath(TodayDealsConstants.today_deals);


    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public Login clickSignIn(){
        WebElement clickSign = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(login_button));
        clickSign.click();
        return new Login(driver);
    }

    public void fillSearch(String a){
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(searchField));
        searchButton.sendKeys(a);
        searchButton.submit();
    }


    public SearchResultPage search(String searchItem){
        fillSearch(searchItem);
        return new SearchResultPage(driver);
    }

    public TodayDeals clickTodayDeals(){
        WebElement clickTodayDeals = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(today_deals));
        clickTodayDeals.click();
        return new TodayDeals(driver);
    }





}
