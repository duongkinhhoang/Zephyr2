package controls;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.DataPlacement.FILE_DOWNLOAD;
import static runner.Constants.DEFAULT_WAIT_TIME;
import static runner.Constants.WAIT_PAGE_LOADED;

public class WaitElement {
    public static WebElement waitForElementVisible(By by) {
        waitForElementPresent(by);

        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            boolean check = Verify.isElementVisible(by, 1);
            if (check) {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            } else {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        } catch (Throwable error) {
            //Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }

        return null;
    }

    public static WebElement waitForElementVisibleClick(By by) {
        waitForElementPresent(by);

        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable error) {
            //Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }

        return null;
    }


    public static WebElement waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
           // Assert.fail("Element not exist. " + by.toString());
        }
        return null;
    }

    public static boolean waitForElementInVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME), Duration.ofMillis(500));
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(by)));
            return true;
        } catch (Throwable error) {
           // Assert.fail("Element not exist. " + by.toString());
        }
        return false;
    }

    public static boolean verifyAlertPresent(int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Throwable error) {
           // Assert.fail("Not found Alert.");
            return false;
        }
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                //Assert.fail("Timeout waiting for page load (Javascript). (" + WAIT_PAGE_LOADED + "s)");
            }
        }
    }

    public static void waitForFileDownload(int downloadTimeout) {
        File file = new File(FILE_DOWNLOAD);
        long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(downloadTimeout);

        while (System.currentTimeMillis() < endTime) {
            if (file.exists()) {
                return;
            }
        }

        throw new RuntimeException("File download process not completed within the specified timeout.");
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
