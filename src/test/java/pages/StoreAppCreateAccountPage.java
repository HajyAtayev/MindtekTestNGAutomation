package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppCreateAccountPage {

    public  StoreAppCreateAccountPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "id_gender1")
    public WebElement gender;

    @FindBy(id="customer_firstname")
    public WebElement FirstNameBox;

    @FindBy(id="customer_lastname")
    public WebElement LastNameBox;

    @FindBy(id="email")
    public WebElement EmailBox;

    @FindBy(id="passwd")
    public WebElement PasswordBox;

    @FindBy(id="days")
    public WebElement daysBox;

    @FindBy(id="months")
    public WebElement monthsBox;

    @FindBy(id="years")
    public WebElement yearsBox;

    @FindBy(id="address1")
    public WebElement address1Box;

    @FindBy(id="city")
    public WebElement cityBox;

    @FindBy(id="id_state")
    public WebElement stateBox;

    @FindBy(xpath="//option[@id='id_state']/option[15]")
    public WebElement stateBoxOption;

    @FindBy(id="postcode")
    public WebElement postcodeBox;

    @FindBy(id="id_country")
    public WebElement countryBox;

    @FindBy(id="phone_mobile")
    public WebElement phonemobileBox;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

}
