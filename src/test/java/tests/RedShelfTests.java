package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class RedShelfTests {

    WebDriver driver;

    @BeforeMethod

    public  void setUp(){
        //SetUp the driver
        //1. Setproperty-> we need chromedriver
        //2. Create WebDriver object

        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver= Driver.getDriver();

    }

    @Test (groups={"regression"})
    public void test2(){
        driver.get("https://redshelf.com/");

        String expectedTitle = "RedShelf";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(groups={"regression","smoke"})
    public void test3(){

        driver.get(ConfigReader.getProperty("RedShelfURL"));
        driver.findElement(By.id("search-catalog-navbar")).sendKeys("Java data structure"+ Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookName= driver.findElement(By.xpath("//h1/span")).getText();
        String eISBN = driver.findElement(By.xpath("//span[@class='significant-isbn']")).getText();
        System.out.println(eISBN);
        driver.findElement(By.id("search-catalog-navbar")).sendKeys(eISBN+Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookNameISBN = driver.findElement(By.xpath("//h1/span")).getText();

        Assert.assertEquals(bookNameISBN,bookName);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
