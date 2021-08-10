package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppLoginPage {
    public StoreAppLoginPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "SubmitCreate")
    public WebElement submitButton;

    @FindBy(id = "email_create")
    public WebElement emailBox;

}

