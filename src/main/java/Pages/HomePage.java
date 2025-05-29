package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class HomePage {

    WebDriver driver;
    CommonFunctions commonFunctions;

    @FindBy(xpath = "//div[@class='card-body']/h5[normalize-space(text())='Elements']")
    WebElement elementButton;


    @FindBy(xpath = "//div[normalize-space()='Alerts, Frame & Windows']")
    WebElement alertFramesButton;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        commonFunctions = new CommonFunctions(this.driver);

    }


    public boolean clickOnElementButton() {
        commonFunctions.scrollByJavaScriptExecutor(36, 518);
        if (commonFunctions.waitForElementToBeClickable(this.elementButton, 20)) {
            elementButton.click();
            return true;
        }
        return false;


    }

    public boolean clickOnAlertButton() {
        commonFunctions.scrollByJavaScriptExecutor(36, 518);
        if (commonFunctions.waitForElementToBeClickable(this.alertFramesButton, 20)) {
            alertFramesButton.click();
            return true;
        }
        return false;


    }


}
