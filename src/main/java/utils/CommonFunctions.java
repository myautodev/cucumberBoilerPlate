package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonFunctions {


    WebDriver driver;

    WebDriverWait wait;

    Actions actions;

    String originalWindow;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;

    }

    public boolean waitForElementToBeClickable(WebElement element, int time) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(time));
        return wait.until(d -> element.isDisplayed());

    }

    public boolean waitForElementToBeEnabbled(WebElement element, int time) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(time));
        return wait.until(d -> element.isEnabled());

    }

    public boolean waitForElementToBeVisible(WebElement element, int time) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(time));
        return wait.until(d -> element.isDisplayed());

    }


    public boolean scrollByActionsAmount(int x, int y) {
        try {
            actions = new Actions(this.driver);
            System.out.println("into scroll");
            actions.scrollByAmount(x, y);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public boolean scrollByJavaScriptExecutor(int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public void clickOnElementFromList(int elementNumber, String xpath) {

        List<WebElement> myList = this.driver.findElements(By.xpath(xpath));
        myList.get(elementNumber).click();
    }


    public boolean scrollToElement(WebElement webElement) {
        try {
            actions = new Actions(this.driver);
            actions.scrollToElement(webElement);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public WebElement getElementToClick(String elementText) {
        String xpath = String.format("//span[text()='%s']", elementText);
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found with text: " + elementText);
            return null;
        }
    }


    public static List<String> extractTextAfterColon(String input) {
        List<String> result = new ArrayList<>();
        String[] lines = input.split("\\r?\\n"); // Split by line

        for (String line : lines) {
            int colonIndex = line.indexOf(':');
            if (colonIndex != -1 && colonIndex + 1 < line.length()) {
                result.add(line.substring(colonIndex + 1).trim());
            }
        }

        return result;
    }

    public static boolean compareInfoLists(List<String> entered, List<String> extracted) {
        boolean flag = false;

        if (entered.equals(extracted)) {
            System.out.println("✅ Entered info matches extracted info exactly.");
            flag = true;
        } else {
            System.out.println("❌ Mismatch found between entered and extracted info:");

            int maxSize = Math.max(entered.size(), extracted.size());

            for (int i = 0; i < maxSize; i++) {
                String enteredItem = i < entered.size() ? entered.get(i) : "(missing)";
                String extractedItem = i < extracted.size() ? extracted.get(i) : "(missing)";

                if (!enteredItem.equals(extractedItem)) {
                    System.out.println(" - At index " + i + ":");
                    System.out.println("   Entered  : " + enteredItem);
                    System.out.println("   Extracted: " + extractedItem);

                }
            }
        }
        return flag;
    }

    public void switchToNewWindowHandle() {
        this.originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }


    }

    public void switchBackToOriginalWindow() {
        if (originalWindow != null) {
            driver.switchTo().window(originalWindow);
        }
    }


}



