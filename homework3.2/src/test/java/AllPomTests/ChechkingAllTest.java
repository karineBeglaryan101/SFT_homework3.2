package AllPomTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.Login;
import pages.common.SearchResultPage;
import pages.common.TodayDeals;


public class ChechkingAllTest extends BaseTest {
    @Test
    public void testAll(){
        SearchResultPage search = homePage.search("A Man Called Ove book");
        pages.common.Item book = search.goOnItem();
        String name = book.name();
        Assert.assertTrue(name.contains("A Man Called Ove"));
        TodayDeals deals = homePage.clickTodayDeals();
        String a = deals.viewLogo();
        Assert.assertTrue(a.contains("Today's Deals"));
        Login page = homePage.clickSignIn();
        String error = page.error("aaa");
        Assert.assertTrue(error.contains("We cannot find an account with that email address"));
    }
}
