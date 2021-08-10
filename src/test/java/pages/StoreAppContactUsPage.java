package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppContactUsPage {

    public StoreAppContactUsPage(){

        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id ="id_contact")
    public WebElement subjectHeadingDropDown;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "id_order")
    public WebElement referenceOrder;

    @FindBy(id = "fileUpload" )
    public WebElement fileUpload;

    @FindBy(id ="message")
    public WebElement message;

    @FindBy (id = "submitMessage")
    public WebElement submitButton;

    @FindBy (xpath = "//p[@class='alert alert-success']")
    public WebElement successMessage;

    @FindBy (xpath = "//div[@class='alert alert-danger']//li")
    public WebElement errorMessage;


}

