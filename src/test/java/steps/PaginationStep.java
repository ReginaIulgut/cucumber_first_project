package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalBasePage;
import utils.Driver;

public class PaginationStep {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalBasePage techGlobalBasePage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalBasePage = new TechGlobalBasePage();

    }

    @And("user should see {string} heading")
    public void userShouldSeeHeading(String heading) {
        switch (heading) {
            case "Pagination":
                driver.get(driver.getCurrentUrl());
                Assert.assertEquals(techGlobalBasePage.mainHeading.getText(), heading);
                break;
            case "World City Populations 2022":
                Assert.assertEquals(techGlobalBasePage.subHeading.getText(), heading);
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} paragraph")
    public void userShouldSeeParagraph(String paragraph) {
        Assert.assertEquals(techGlobalBasePage.paragraph.getText(), paragraph);
    }

    @And("user should see {string} button is disabled")
    public void userShouldSeeButtonIsDisabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(techGlobalBasePage.previousButton.isDisplayed());
                break;
            case "Next":
                Assert.assertTrue(techGlobalBasePage.nextButton.isDisplayed());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} button is enabled")
    public void userShouldSeeButtonIsEnabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(techGlobalBasePage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalBasePage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton() {
        techGlobalBasePage.nextButton.click();
    }

    @When("user clicks on {string} button till it becomes disabled")
    public void userClicksOnButtonTillItBecomesDisabled() {
        while (techGlobalBasePage.nextButton.isEnabled()){
            techGlobalBasePage.nextButton.click();
        }
    }

    @And("user should see city with info below and an image")
    public void userShouldSeeCityWithInfoBelowAndAnImage(DataTable info) {

        for (int i = 0; i < info.asList().size(); i++){
            Assert.assertEquals(techGlobalBasePage.cityInfo.get(i).getText(), info.asList().get(i));
            System.out.println(techGlobalBasePage.cityInfo.get(i).getText());
        }
        techGlobalBasePage.nextButton.click();
    }
}