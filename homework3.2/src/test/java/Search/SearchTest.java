package Search;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.SearchResultPage;

public class SearchTest extends BaseTest {

    @Test
    public void testSuccessfulDiscounts(){
        SearchResultPage search = homePage.search("A Man Called Ove");
        String a = search.clickOnDiscounts();
        Assert.assertEquals(a,"All Discounts");
    }
    @Test
    public void testAuthorName(){
        SearchResultPage search = homePage.search("A Man Called Ove book");
        String a = search.author_name();
        Assert.assertEquals(a,"Fredrik Backman");
    }
    @Test
    public void testClickOnBooks(){
        SearchResultPage search = homePage.search("A Man Called Ove");
        String a = search.clickOnBooks();
        Assert.assertEquals(a,"Books");
    }




}
