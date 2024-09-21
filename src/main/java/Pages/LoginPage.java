package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {


    WebDriver driver;


    By myAccountButton = By.xpath("//span[contains(text(),'My account')]");

    By userNameField = By.xpath("//input[@id='username']");

    By passwordField = By.xpath("//input[@id='password']");

    By loginButton = By.xpath("//button[@name='login']");


    public LoginPage(WebDriver driver){

        this.driver = driver;


    }



    public boolean clickOnMyAccountButton(){
        WebElement myaccountButton = driver.findElement(this.myAccountButton);
        if(myaccountButton.isDisplayed()){
            myaccountButton.click();
            System.out.println("User has clicked on the my account button");
            //TODO LOG TO LOG4J
            return true;
        }

        else{

            System.out.println("User has NOT clicked on the my account button");
            //TODO LOG TO LOG4J
            return false;
        }

    }

    public boolean enterUsername(String username) {
        WebElement usernameField = driver.findElement(this.userNameField);
        if (usernameField.isDisplayed()) {
            usernameField.sendKeys(username);
            System.out.println("User has entered the username " + username);
            //TODO LOG TO LOG4J
            return true;
        } else {

            System.out.println("User could not enter the username " + username);
            //TODO LOG TO LOG4J
            return false;
        }
    }

        public boolean enterPassword(String password) {
            WebElement passwordField = driver.findElement(this.passwordField);
            if (passwordField.isDisplayed()) {
                passwordField.sendKeys(password);
                System.out.println("user has entered the password");
                return true;

            } else {

                System.out.println("user has NOT entered the password");
                return false;

            }
        }


        public boolean clickOnLogin(){
            WebElement loginButton = driver.findElement(this.loginButton);
            if(loginButton.isDisplayed()){
                loginButton.click();
                System.out.println("User has clicked on the login button");
                return true;
            }

            else{

                System.out.println("User has NOT clicked on the login button");
                return false;

            }
            }


    }








