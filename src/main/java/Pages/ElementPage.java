package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.HashMap;

public class ElementPage {


    WebDriver driver;
    CommonFunctions commonFunctions;

    @FindBy(xpath = " //div[normalize-space()='Elements']")
    WebElement elementButton;
    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement textBox;


    String listForElementXpath = "//div[@class='header-right']/div[@class='icon']";

    HashMap<String, Integer> elementList = new HashMap<>();  // ✅ Initialize it


    public ElementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        commonFunctions = new CommonFunctions(this.driver);


    }

    public void setElementList() {

        elementList.put("elements", 0);
        elementList.put("form", 1);
        elementList.put("alertFrames", 2);
        elementList.put("widgets", 3);
        elementList.put("interactions", 4);
        elementList.put("bookStore", 5);

    }

    public boolean clickOnElementButton() {
        commonFunctions.scrollByJavaScriptExecutor(36, 518);
        if (commonFunctions.waitForElementToBeClickable(this.elementButton, 20)) {
            elementButton.click();
            return true;
        }
        return false;


    }

    public boolean clickOnDropDown(String dropDownName) {
        setElementList();


        try {

            commonFunctions.clickOnElementFromList(elementList.get(dropDownName), listForElementXpath);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean clickOnElementType(String elementTypeSelect) {

        WebElement elementToClick = commonFunctions.getElementToClick(elementTypeSelect);

        if (elementToClick != null && commonFunctions.waitForElementToBeClickable(elementToClick, 10)) {
            elementToClick.click();
            return true;
        }

        return false;
    }

}
