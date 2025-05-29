package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import static org.asynchttpclient.util.Assertions.assertNotNull;


public class AlertsAndFrames {

    private final WebDriver driver;
    private final CommonFunctions commonFunctions;

    @FindBy(xpath = " //button[@id='tabButton']")
    WebElement newTabButton;

    @FindBy(xpath = " //button[@id='windowButton']")
    WebElement windowButton;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement textOfNewSecondTab;


    public AlertsAndFrames(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        commonFunctions = new CommonFunctions(this.driver);
    }


    public boolean clickOnElementType(String elementTypeSelect) {
        WebElement elementToClick = commonFunctions.getElementToClick(elementTypeSelect);
        if (elementToClick != null && commonFunctions.waitForElementToBeClickable(elementToClick, 10)) {
            elementToClick.click();
            return true;
        }

        return false;
    }

    public boolean clickOnNewTabButton() {
        if (commonFunctions.waitForElementToBeClickable(newTabButton, 10)) {
            newTabButton.click();
            return true;


        }
        return false;

    }

    public boolean clickOnWindowButton() {
        if (commonFunctions.waitForElementToBeVisible(windowButton, 10)) {
            windowButton.click();
            return true;
        }

        return false;
    }

    public boolean switchToNewWindowHandle() {
        try {
            commonFunctions.switchToNewWindowHandle();
            return true;
        } catch (Exception e) {
            return false;


        }


    }

    public boolean switchToOriginalWindowHandle() {
        try {
            commonFunctions.switchBackToOriginalWindow();
            return true;
        } catch (Exception e) {
            return false;


        }


    }

    public boolean matchTextOfNewTab(String textToMatch) {
        return textOfNewSecondTab.getText().equalsIgnoreCase(textToMatch);

    }
}








