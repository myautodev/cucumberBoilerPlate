package stepDefs;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.logging.Handler;

public class MyStepdefs extends TestBase {

    LoginPage loginPage;
    HomePage homePage;



    @Given("I am logged into the app with {string} and  {string}")
    public void iAmLoggedIntoTheApp(String username,String password) {
        startDriver();
        driver.get("https://www.nationallottery.co.za/");
        loginPage = new LoginPage(driver);
        Assert.assertTrue("User could not click on the myaccount button",loginPage.clickOnMyAccountButton());
        Assert.assertTrue("User Could not enter the username",loginPage.enterUsername(username));
        Assert.assertTrue("User Could not enter the password",loginPage.enterPassword(password));
        Assert.assertTrue("User could not click on Login",loginPage.clickOnLogin());






    }

    @When("I navigate to the shop")
    public void iNavigateToTheShop() {

        homePage = new HomePage(driver);
        Assert.assertTrue("User could not click on homePage", homePage.clickOnShopButton());

    }

    @When("I select the product and add to cart")
    public void iSelectTheProductAndAddToCart() {
    }

    @When("I click on checkout")
    public void iClickOnCheckout() {
    }

    @Then("I print the order Number")
    public void iPrintTheOrderNumber() {
    }


}
