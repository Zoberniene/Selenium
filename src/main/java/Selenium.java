import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    private static WebDriver browser;
    public static void main(String [] args) {
        setup();
        addMovie("Last weekend","Comedy","love", "aniston", "126");
        wrongMovie("@.",",/@>@","/[]@", "jdjdj", ".");
        deleteMovie("6");
        updateMovie("7","gogo","tragedy","snow", "jojo", "167");
        wrongUpdate("67.,/l",";,'l","...","!.,/.", "kl.,", "u");
    }

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver91"); //nesvarbu, koks vartotojas prisijunges prie sistemos, musu driveris yra projekte
        browser = new ChromeDriver();
        browser.get("http://kitm.epizy.com/filmai.php");//atidarys narsykle
    }

    public static void addMovie(String keyword, String keyword2, String keyword3, String keyword4, String keyword5){
        WebElement nameField = browser.findElement(By.name("pavadinimas"));
        nameField.sendKeys(keyword);
        WebElement genreField = browser.findElement(By.name("zanras"));
        genreField.sendKeys(keyword2);
        WebElement actorField = browser.findElement(By.name("aktoriai"));
        actorField.sendKeys(keyword3);
        WebElement producerField = browser.findElement(By.name("rezisierius"));
        producerField.sendKeys(keyword4);
        WebElement timeField = browser.findElement(By.name("trukme"));
        timeField.sendKeys(keyword5);
        WebElement sendField = browser.findElement(By.name("insert"));
        sendField.click();
    }

    public static void wrongMovie(String keyword, String keyword2, String keyword3, String keyword4, String keyword5){
        WebElement nameField = browser.findElement(By.name("pavadinimas"));
        nameField.sendKeys(keyword);
        WebElement genreField = browser.findElement(By.name("zanras"));
        genreField.sendKeys(keyword2);
        WebElement actorField = browser.findElement(By.name("aktoriai"));
        actorField.sendKeys(keyword3);
        WebElement producerField = browser.findElement(By.name("rezisierius"));
        producerField.sendKeys(keyword4);
        WebElement timeField = browser.findElement(By.name("trukme"));
        timeField.sendKeys(keyword5);
        WebElement sendField = browser.findElement(By.name("insert"));
        sendField.click();
    }

    public static void deleteMovie(String keyword){
        WebElement idField = browser.findElement(By.name("id"));
        idField.sendKeys(keyword);
        WebElement deleteField = browser.findElement(By.name("delete"));
        deleteField.click();
    }

    public static void updateMovie(String keyword,String keyword2,String keyword3,String keyword4, String keyword5,String keyword6){
        WebElement idField = browser.findElement(By.name("id"));
        idField.sendKeys(keyword);
        WebElement nameField = browser.findElement(By.name("pavadinimas"));
        nameField.sendKeys(keyword2);
        WebElement genreField = browser.findElement(By.name("zanras"));
        genreField.sendKeys(keyword3);
        WebElement actorField = browser.findElement(By.name("aktoriai"));
        actorField.sendKeys(keyword4);
        WebElement producerField = browser.findElement(By.name("rezisierius"));
        producerField.sendKeys(keyword5);
        WebElement timeField = browser.findElement(By.name("trukme"));
        timeField.sendKeys(keyword6);
        WebElement updateField = browser.findElement(By.name("update"));
        updateField.click();
    }

    public static void wrongUpdate(String keyword,String keyword2,String keyword3,String keyword4, String keyword5,String keyword6){
        WebElement idField = browser.findElement(By.name("id"));
        idField.sendKeys(keyword);
        WebElement nameField = browser.findElement(By.name("pavadinimas"));
        nameField.sendKeys(keyword2);
        WebElement genreField = browser.findElement(By.name("zanras"));
        genreField.sendKeys(keyword3);
        WebElement actorField = browser.findElement(By.name("aktoriai"));
        actorField.sendKeys(keyword4);
        WebElement producerField = browser.findElement(By.name("rezisierius"));
        producerField.sendKeys(keyword5);
        WebElement timeField = browser.findElement(By.name("trukme"));
        timeField.sendKeys(keyword6);
        WebElement updatefield = browser.findElement(By.name("update"));
        updatefield.click();
    }

    public static void close(){
        browser.close(); //metodas, uzdarantis narsykles langa
    }

}

