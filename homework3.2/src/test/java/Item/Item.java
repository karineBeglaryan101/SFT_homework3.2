package Item;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.Login;
import pages.common.SearchResultPage;

public class Item extends BaseTest {

    @Test
    public void testGoingOnItem(){
        SearchResultPage search = homePage.search("A Man Called Ove book");
        pages.common.Item book = search.goOnItem();
        String name =  book.name();
        Assert.assertTrue(name.contains("A Man Called Ove"));
    }

    @Test
    public void testItemInformation(){
        SearchResultPage search = homePage.search("A Man Called Ove book");
        pages.common.Item book = search.goOnItem();
        String name =  book.info();
        Assert.assertTrue(name.contains("9 hours and 13 minutes"));
    }

    @Test
    public void testAddWishlist(){
        SearchResultPage search = homePage.search("A Man Called Ove book");
        pages.common.Item book = search.goOnItem();
        Login page =  book.addWishlisht();
        String a = page.sLogin("mb309970@gmail.com", "2=&d/JUA2*EMkNq");
        Assert.assertTrue(a.contains("Signed in"));
    }








}
