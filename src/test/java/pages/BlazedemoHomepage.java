package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazedemoHomepage {


    //
    //FindBy

    public BlazedemoHomepage(){

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);// this -> this BlazedemoHomepage class
    }


    //attribute

   @FindBy(xpath = "//input[@class='btn btn-primary']")
   public WebElement findFlightsButton;

    //public WebElement findFlightsButton = driver.findElement(By.xpath = "//input[@class='btn btn-primary']"));

    @FindBy(name = "frontPort")
    public WebElement fronCityDropdown;
}
