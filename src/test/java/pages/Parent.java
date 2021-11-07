package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseDriver;

import java.util.List;

;

public class Parent {
    Actions actions = new Actions(BaseDriver.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), 20);
    JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();


    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        //scrollToElement(element);
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) BaseDriver.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void delay(int second) {
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyElementContainsText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        Assert.assertTrue(webElement.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void verifyElement(WebElement element) {
        waitUntilVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void elementsToBeMoreThan(By locator, int piece) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, piece));
    }

    public void listSelection(List<WebElement> list, int expected) {
        clickFunction(list.get(expected));
    }
    public void listSelection(List<WebElement> list, String expected) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(expected)) {
                clickFunction(list.get(i));
                break;
            }
        }
    }

    public String returnListedElementName(List<WebElement> list, int expected) {
        return String.valueOf(list.get(expected));
    }

    public void actionOnElements(WebElement element) {
        delay(2);
        Action action = actions.moveToElement(element).build();
        action.perform();
    }

    public void actionOnElementsAndClick(WebElement element) {
        delay(2);
        Action action = actions.moveToElement(element).click().build();
        action.perform();
    }

}



