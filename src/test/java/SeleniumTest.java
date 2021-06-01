import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    @BeforeTest
    public void setup(){
        Selenium.setup();
    }

    @Test(priority=1)
    public void searchByKeywordTest(){
        Selenium.search("Baranauskas");
    }

    @Test(priority=2)
    public void getResults(){
        Selenium.search("Baranauskas");
        //pirmas parametras bus expected, antras - actual
        Assert.assertEquals(Selenium.getResults(), 193000);
    }

    @AfterTest
    public void close(){
        Selenium.close();
    }
}
