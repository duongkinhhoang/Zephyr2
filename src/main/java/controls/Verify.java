package controls;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static controls.WebUI.getTextElement;
import static runner.Constants.DEFAULT_WAIT_TIME;

public class Verify {
    public static boolean verifyElementText(By by, String text) {
        WaitElement.waitForElementVisible(by);
        return getTextElement(by).trim().equals(text.trim());
    }

    public static boolean verifyElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception e) {
            //Assert.fail("[ERROR] The element is NOT clickable: " + by);
            return false;
        }
    }

    public static boolean verifyElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));

            return true;
        } catch (Exception e) {
            //Assert.fail("[ERROR] The element is NOT present: " + by);
            return false;
        }
    }

    public static boolean verifyElementNotPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));

            return false;
        } catch (Exception e) {
            //Assert.fail("[ERROR] The element is present: " + by);
            return true;
        }
    }

    public static boolean verifyElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));

            return true;
        } catch (Exception e) {
            //Assert.fail("[ERROR] The element is NOT visible: " + by);
            return false;
        }
    }

    public static boolean verifyElementInvisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

            return true;
        } catch (Exception e) {
            //Assert.fail("[ERROR] The element is visible: " + by);
            return false;
        }
    }

    //Handle checkbox and radio button
    public static boolean verifyElementChecked(By by) {
        return WebUI.getWebElement(by).isSelected();
    }

    public static boolean isElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementVisible(By by, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
