import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static final String SEARCH_BUTTON_BY_XPATH = "//*[@id=\"sb_form_go\"]";
    private static WebDriver browser;  //susikureme globalu kintamaji
    public static void main(String [] args) {
        System.out.println("Selenium");
//        setup();
//        search("Baranauskas");
//        getResults();
//        close();
    }

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver91"); //nesvarbu, koks vartotojas prisijunges prie sistemos, musu driveris yra projekte
        browser = new ChromeDriver();
        browser.get("https://bing.com");//atidarys narsykle
    }

    public static void search(String keyword){
        //siuo atveju unikalus web elemento identifikatorius surandamas pagal id, bet galima naudoti ir kitus budus - By.name, By.className, By.xpath
        WebElement searchfield = browser.findElement(By.id("sb_form_q"));
        //suradus elementa puslapyje, i ji irasomas paieskos raktinis zodis (pvz.: Baranauskas)
        searchfield.sendKeys(keyword);
        //Irasius paieskos raktini zodi paspaudziamas ENTER mygtukas (ieskoti)
        //searchfield.sendKeys(Keys.ENTER);

        //1. VEIKIANTIS VARIANTAS naudojant JavascriptExecutor
        WebElement ele = browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();", ele);   //ele yra tas elementas, kuri norime, kad paspaustu

/*
        //2. NEVEIKIA, kur naudojamas Javascript.
        WebDriverWait wait2 = new WebDriverWait(browser, 2);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SEARCH_BUTTON_BY_XPATH)));
        browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH)).click();
        //3. NEVEIKIA, kur naudojamas Javascript
        WebDriverWait wait1 = new WebDriverWait(browser, 10);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON_BY_XPATH)));
        element1.click();
*/

    }

    public static int getResults(){
        //toliau yra naudojamas reliatyvus kelias iki elemento
        WebElement result2 = browser.findElement(By.xpath("//*[@id=\"b_tween\"]/span"));

        String resultStr = result2.getText()
                .replaceAll("[a-zA-Z]", "")
                .replaceAll("[ ,]","");

        //konvertuojame is String i int, nes mums reikes palyginti rezultata (i Stringa gali tilpti viskas, tiek skaiciai, tiek simboliai)
        int resultInt = Integer.parseInt(resultStr);
        System.out.println(resultInt);
        return resultInt;
    }

    public static void close(){
        browser.close(); //metodas, uzdarantis narsykles langa
    }

}

