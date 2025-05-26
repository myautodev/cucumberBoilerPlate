package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.CommonFunctions.compareInfoLists;

public class TextBox {


    WebDriver driver;
    CommonFunctions commonFunctions;

    @FindBy(id = "userName")
    WebElement userNameInputBox;

    @FindBy(id = "userEmail")
    WebElement userEmailInputBox;

    @FindBy(id = "currentAddress")
    WebElement userAddressInputBox;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddressInputBox;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id= "output")
    WebElement outPutBox;




    public TextBox(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        commonFunctions = new CommonFunctions(this.driver);


    }

    public boolean enterUserName(String userNameToEnter) {
        commonFunctions.scrollByJavaScriptExecutor(379, 322);
        if (userNameToEnter != null && commonFunctions.waitForElementToBeClickable(this.userNameInputBox, 20)) {
            userNameInputBox.sendKeys(userNameToEnter);
            return true;
        }
        return false;


    }

    public boolean enterUserEmail(String emailToEnter) {
        if (emailToEnter != null && commonFunctions.waitForElementToBeClickable(this.userEmailInputBox, 20)) {
            userEmailInputBox.sendKeys(emailToEnter);
            return true;
        }
        return false;


    }


    public boolean enterCurrentAddress(String addressToEnter) {
        if (addressToEnter != null && commonFunctions.waitForElementToBeClickable(this.userAddressInputBox, 20)) {
            userAddressInputBox.sendKeys(addressToEnter);
            return true;
        }
        return false;


    }

    public boolean enterPermAddress(String permanentAdressToEnter) {
        if (permanentAdressToEnter != null && commonFunctions.waitForElementToBeClickable(this.permanentAddressInputBox, 20)) {
            permanentAddressInputBox.sendKeys(permanentAdressToEnter);
            return true;
        }
        return false;


    }

    public boolean clickOnSubmitButton() {
        commonFunctions.scrollByJavaScriptExecutor(656, 498);

        if (commonFunctions.waitForElementToBeClickable(this.submitButton, 20)) {
            submitButton.click();
            return true;
        }
        return false;


    }

    public boolean checkIfOutputBoxHasCorrectInfo(String fullname, String emalAdress, String currentAddToCheck, String permAddressAddToCheck) {

        List<String> enteredInfo = new ArrayList<>();
        enteredInfo.add(fullname);
        enteredInfo.add(emalAdress);
        enteredInfo.add(currentAddToCheck);
        enteredInfo.add(permAddressAddToCheck);


        String input = outPutBox.getText();

        List<String> extracted = commonFunctions.extractTextAfterColon(input);
        return compareInfoLists(enteredInfo, extracted);


    }





}




