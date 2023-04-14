package base;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.common.HomePage;
import java.io.File;
import java.io.IOException;


public class BaseTest {
    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/Drivers/chromedriver";
    public static final String baseURL = "https://www.amazon.com/";

    private WebDriver driver;
    protected HomePage homePage;



    @BeforeClass
   public void setUp(){
       System.setProperty(WEBDRIVER,DRIVER_PATH);
       driver =  new ChromeDriver();
       driver.manage().window().maximize();
       goHome();
   }


    @BeforeMethod
    public void goHome(){
        driver.get(baseURL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("src/screenshots" +  result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }






}
