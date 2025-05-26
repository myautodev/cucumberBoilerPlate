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


}
