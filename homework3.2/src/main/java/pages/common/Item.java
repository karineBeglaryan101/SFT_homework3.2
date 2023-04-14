package pages.common;

import locators.ItemConstants;
import locators.SearchResultConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Item {
    private WebDriver driver;
    private By product_name = By.id(ItemConstants.ITEM_NAME);
    private By addButton = By.id(ItemConstants.add_button);
    private By information = By.id(ItemConstants.audioBookInformation);

    public Item(WebDriver driver){
        this.driver= driver;
    }

    public String name(){
        WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(product_name));
        return name.getText();
    }

    public Login addWishlisht(){
        driver.findElement(addButton).click();
        return new Login(driver);
    }

    public String info(){
        WebElement info = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(information));
        return info.getText();
    }






}
