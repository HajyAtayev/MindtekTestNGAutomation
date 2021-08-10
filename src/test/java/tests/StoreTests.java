package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

    public class StoreTests extends TestBase{
        StoreAppHomePage StoreAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage StoreAppContactUsPage = new StoreAppContactUsPage();

        @Test(groups={"regression","smoke"})
        public void test1(){
            driver.get(ConfigReader.getProperty("StoreAppURL"));
            StoreAppHomePage.contactUsButton.click();
            Select select = new Select(StoreAppContactUsPage.subjectHeadingDropDown);
            select.selectByValue("2");
            StoreAppContactUsPage.email.sendKeys("123@gmail.com");
            String projectPath = System.getProperty("user.dir");//C:\Users\Ben Atayeff\IdeaProjects\MindtekTestNGAutomation\
            System.out.println("Path for our project is:"+ projectPath);
            StoreAppContactUsPage.fileUpload.sendKeys(projectPath+"\\src\\test\\resources\\testdata\\MyImage.jpg");

            StoreAppContactUsPage.message.sendKeys("Hello World");
            StoreAppContactUsPage.submitButton.click();

            String actualSuccessMessage = StoreAppContactUsPage.successMessage.getText();
            String expectedSuccessMessage = "Your message has been successfully sent to our team.";

            Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

        }

        @Test(groups={"regression","smoke"})
    public void test2(){
            driver.get(ConfigReader.getProperty("StoreAppURL"));
            StoreAppHomePage.contactUsButton.click();
            Select select = new Select(StoreAppContactUsPage.subjectHeadingDropDown);
            select.selectByValue("2");
            StoreAppContactUsPage.email.sendKeys("123@gmail.com");
            String projectPath = System.getProperty("user.dir");//C:\Users\Ben Atayeff\IdeaProjects\MindtekTestNGAutomation\
            System.out.println("Path for our project is:"+ projectPath);
            StoreAppContactUsPage.fileUpload.sendKeys(projectPath+"\\src\\test\\resources\\testdata\\MyImage.jpg");

            StoreAppContactUsPage.submitButton.click();
            String actualErrorMessage = StoreAppContactUsPage.errorMessage.getText();
            String expectedErrorMessage = "The message cannot be blank.";

            Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        }
    }


