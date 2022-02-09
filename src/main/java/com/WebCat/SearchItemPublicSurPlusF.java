package com.WebCat;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class SearchItemPublicSurPlusF {


    private WebDriver driver;
    private static final String TIPO_DRIVER = "webdriver.gecko.driver";
    private static final String PATH_DRIVER = "./src/test/resources/firefoxdriver/geckodriver.exe";
    private String URL = "https://www.publicsurplus.com/sms/browse/home";


    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("INICIO DE TEST");
        System.setProperty(TIPO_DRIVER, PATH_DRIVER);

    }


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void SearchItemPublicSurPlus() {
        WebElement searchitem = driver.findElement(By.name("Submit4"));
        searchitem.click();
        WebElement input_keyword = driver.findElement(By.id("keyword"));
        input_keyword.sendKeys("#3");
        Select list_auctionends = new Select(driver.findElement(By.name("endHours")));
        list_auctionends.selectByValue("120");
        WebElement input_pricefrom = driver.findElement(By.name("lowerPrice"));
        input_pricefrom.clear();
        input_pricefrom.sendKeys("21");
        WebElement input_priceup = driver.findElement(By.name("higherPrice"));
        input_priceup.clear();
        input_priceup.sendKeys("25");
        WebElement btn_search = driver.findElement(By.xpath("/html/body/div[2]/div[8]/form/div[8]/input"));
        btn_search.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MINUTES);
        String table_results = driver.findElement(By.xpath("/html/body/div[2]/table")).getText();
        System.out.println(table_results);

    }

    @After
    public void Finish(){
        driver.quit();

    }

}