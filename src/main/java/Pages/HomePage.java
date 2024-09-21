package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver ;

    By shopButton = By.xpath("//span[contains(text(),'Shop')]");




    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public boolean clickOnShopButton(){
        WebElement shopButton = driver.findElement(this.shopButton);
        if(shopButton.isDisplayed()){
            shopButton.click();
            System.out.println("The user has clicked on the shop");
            return true;
        }

        else{

            System.out.println("The user has NOT  clicked on the shop");
            return false;


        }
    }

}
