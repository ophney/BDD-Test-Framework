package PageObject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.WebDriverManager;

import java.time.Duration;

public class BasePage {
    public WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(20));

    public void mySendKeys(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        scrollToElement(element);
        element.sendKeys(value);
    }

    public void myClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void verifyContainsText(WebElement element, String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(WebDriverManager.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js =(JavascriptExecutor) WebDriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
}
