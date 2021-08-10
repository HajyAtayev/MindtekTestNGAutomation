package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazedemoFlightsPage;
import pages.BlazedemoHomepage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTests extends TestBase {

    BlazedemoHomepage blazedemoHomepage = new BlazedemoHomepage();
    BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();


    @Test (groups={"regression"})
    public void test1() {
        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        blazedemoHomepage.findFlightsButton.click();

        List<WebElement> prices = blazedemoFlightsPage.prices;

        for (WebElement element : prices) {
            String priceStr = element.getText();
            // $472.56 == String -> int == Integer.parseInt(String); -> int
            // $472.56 -> 472.56
            priceStr = priceStr.substring(1);
            double priceDouble = Double.parseDouble(priceStr);
            Assert.assertTrue((priceDouble < 1000));
        }
    }
    @Test(groups={"regression"})
    public void test2(){
        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        Select select= new Select(blazedemoHomepage.fronCityDropdown);
        select.selectByValue("Boston");
        select = new Select(blazedemoHomepage.fronCityDropdown);
        select.selectByValue("London");
        blazedemoHomepage.findFlightsButton.click();
        blazedemoFlightsPage.headerText.getText();
        String actualText = blazedemoFlightsPage.headerText.getText();
        String expectedText = "Flight from Boston to London:";
        Assert.assertEquals(actualText,expectedText);

    }
}
