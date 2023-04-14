package todayDeals;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.SearchResultPage;
import pages.common.TodayDeals;

import java.util.List;

public class DealsTest extends BaseTest {
    @Test
    public void testGoingToDeals(){
        TodayDeals deals = homePage.clickTodayDeals();
        String a = deals.viewLogo();
        Assert.assertEquals(a,"Today's Deals");
    }

    @Test
    public void getDeals(){
        TodayDeals deals = homePage.clickTodayDeals();
        boolean result =  deals.deals();
        Assert.assertEquals(result,false);
    }


}
