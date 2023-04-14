package pages.common;


import locators.SearchResultConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// "//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div/div[1]/div[1]/div/div[1]"
public class SearchResultPage {
    private WebDriver driver;
    private By searchBar = By.id(SearchResultConstants.searchBar);
    private By topSeller = By.xpath(SearchResultConstants.TOP_Seller);
    private By books = By.xpath(SearchResultConstants.BOOK_Department);
    private By discounts = By.xpath(SearchResultConstants.DISCOUNTS);
    private By similar_books = By.xpath(SearchResultConstants.author_name);

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickTopSeller(){
        WebElement clickSeller = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(topSeller));
        clickSeller.click();
    }



    public String clickOnBooks(){
        WebElement clickBooks = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(books));
        return clickBooks.getText();
    }

    public String clickOnDiscounts(){
        WebElement clickDiscount = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(discounts));
        return clickDiscount.getText();
    }

    public String author_name(){
        WebElement clickSimilar = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(similar_books));
        return clickSimilar.getText();
    }


    public Item goOnItem(){
        clickTopSeller();
        return new Item(driver);
    }




}
