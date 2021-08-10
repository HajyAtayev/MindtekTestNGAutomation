package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {

    @DataProvider (name= "signUpDataProvider")
    public static Object[][] testData() {
        Object[][] data = new Object[][]{
                {"John", "Doe", "123456789", "1","2", "2021","123 Clark St.", "Chicago","13","12345","21","123456789" },
                {"Kim", "Yi", "abcdefg","1","3","1980","2 MyRoad","New York","32","54321","21","987654321"}
        };
        return data;

    }
    @Test(dataProvider="signUpDataProvider", groups={"regression","smoke"})
    public void test1(String firstName,String lastName, String password,String day, String month, String year, String address, String city, String state, String zipcode, String country,String phoneNumber ){
        StoreAppHomePage storeAppHomepage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomepage.loginButton.click();

        Random random = new Random();
        int emailId = random.nextInt(100000);
        String email = "abc" + emailId + "@gmail.com";
        storeAppLoginPage.emailBox.sendKeys(DataUtils.generateEmail());
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.FirstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.LastNameBox.sendKeys(lastName);
        storeAppCreateAccountPage.PasswordBox.sendKeys(password);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox, day);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox, year);
        storeAppCreateAccountPage.address1Box.sendKeys(address);
        storeAppCreateAccountPage.cityBox.sendKeys(city);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.stateBox, state);
        storeAppCreateAccountPage.postcodeBox.sendKeys(zipcode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.countryBox, country);
        storeAppCreateAccountPage.phonemobileBox.sendKeys(phoneNumber);
        storeAppCreateAccountPage.registerButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = " My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle, " Actual title " + actualTitle +
                " didn't match with " + expectedTitle);
    }
}

