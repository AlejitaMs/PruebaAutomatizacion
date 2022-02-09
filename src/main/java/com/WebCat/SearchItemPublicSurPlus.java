package com.WebCat;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SearchItemPublicSurPlus {


    private WebDriver driver;
    private static final String TIPO_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_DRIVER = "./src/test/resources/chromedriver/chromedriver.exe";
    private String URL = "https://www.publicsurplus.com/sms/browse/home";


    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("INICIO DE TEST");
        System.setProperty(TIPO_DRIVER, PATH_DRIVER);

    }


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void SearchItemPublicSurPlus() {
        WebElement searchitem = driver.findElement(By.name("Submit4"));
        searchitem.click();
        //searchitem.submit();
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
        WebDriverWait wait = new WebDriverWait(driver,10);
       // thread.sleep(3000);
        wait.until(ExpectedConditions.titleContains("Public Surplus: Buscar una subasta"));
      //  driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        assertEquals("Public Surplus: Buscar una subasta", driver.getTitle());



    }

    @After
     public void Finish(){
        driver.quit();

    }

}
