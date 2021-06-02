import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    @BeforeTest
    public void setup(){
        Selenium.setup();
    }

    @Test
    public void addMovieTest(){
        Selenium.addMovie("Summer","Familie","love", "lolo", "12");
    }
    @Test
    public void wrongMovieTest(){
        Selenium.wrongMovie("@.",",/@>@","/[]@", "jdjdj", ".");
    }
    @Test
    public void deleteMovieTest(){
        Selenium.deleteMovie("6");
    }
    @Test
    public void updateMovieTest(){
        Selenium.updateMovie("7","gogo","tragedy","snow", "jojo", "167");
    }
    @Test
    public void wrongUpdateTest(){
        Selenium.wrongUpdate("67.,/l",";,'l","...","!.,/.", "kl.,", "u");
    }

    @AfterTest
    public void close(){
        Selenium.close();
    }
}
