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



    @Given("I am on the home page")
    public void iAmLoggedIntoTheApp(String username,String password) {
        initializeDriver();
    }

    @When("I navigate to the element page")
    public void iNavigateToTheElementPage() {
        Assert.assertTrue("could not click on homePage.clickOnElementButton() ",homePage.clickOnElementButton());

    }



//    @When("I navigate to the shop")
//    public void iNavigateToTheShop() {
//
//        homePage = new HomePage(driver);
//        Assert.assertTrue("User could not click on homePage", homePage.clickOnShopButton());
//
//    }

//    @When("I select the product and add to cart")
//    public void iSelectTheProductAndAddToCart() {
//    }
//
//    @When("I click on checkout")
//    public void iClickOnCheckout() {
//    }
//
//    @Then("I print the order Number")
//    public void iPrintTheOrderNumber() {
//    }
//
//
//    @Given("I am logged into the app with {string} and  {string} {string} and  {string}")
//    public void iAmLoggedIntoTheAppWithStringAndStringAnd(String arg0, String arg1) {
//
//    }
//
//    @Given("I am logged into the application")
//    public void iAmLoggedIntoTheApplication() {
//        System.out.println("dfsdfsdf");
//    }
//
//    @When("I navigate to the element page")
//    public void iNavigateToTheElementPage() {
//    }
}
