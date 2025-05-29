package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class DynamicProperties {

    private final WebDriver driver;
    public final CommonFunctions commonFunctions;

    @FindBy(id = "enableAfter")
    private WebElement enableAfterButton;

    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    private WebElement visibleAfterButton;

    public DynamicProperties(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonFunctions = new CommonFunctions(this.driver);
    }

    public boolean clickOnEnableAfterButton() {
        if (commonFunctions.waitForElementToBeEnabbled(enableAfterButton, 10)) {
            commonFunctions.scrollByJavaScriptExecutor(261, 234);
            enableAfterButton.click();
            return true;
        }
        return false;
    }

    public boolean clickOnVisibleAfterButton() {
        if (commonFunctions.waitForElementToBeClickable(visibleAfterButton, 10)) {
            visibleAfterButton.click();
            return true;
        }
        return false;
    }
}
