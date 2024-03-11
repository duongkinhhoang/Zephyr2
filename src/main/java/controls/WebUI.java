package controls;

import drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WebUI {

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public static WebElement getElementAtIndex(By by, int index) {
        List<WebElement> elements = getWebElements(by);
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
    }

    public static void sendKeysToElement(By by, int index, String keysToSend) {
        List<WebElement> elements = getWebElements(by);
        if (index >= 0 && index < elements.size()) {
            WebElement element = elements.get(index);
            element.clear();
            element.sendKeys(keysToSend);
        } else {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
    }

    public static String getTextElement(By by) {
        return WaitElement.waitForElementVisible(by).getText().trim();
    }

    public static String getAttributeElement(By by, String attributeName) {
        return WaitElement.waitForElementVisible(by).getAttribute(attributeName);
    }

    public static String getCssValueElement(By by, String cssName) {
        return WaitElement.waitForElementVisible(by).getCssValue(cssName);
    }

    public static Dimension getSizeElement(By by) {
        return WaitElement.waitForElementVisible(by).getSize();
    }

    public static Point getLocationElement(By by) {
        return WaitElement.waitForElementVisible(by).getLocation();
    }

    // ===== handle click =====
    public static void clickElement(By by) {
        WaitElement.waitForElementVisible(by).click();
    }

    public static void rightClickElement(By by) {
        Actions action = new Actions(DriverManager.getDriver());
        action.contextClick(WaitElement.waitForElementVisible(by)).build().perform();
    }

    // ===== handle input text =====
    public static void enterText(By by, String value) {
        WaitElement.waitForElementVisible(by).sendKeys(value);
    }

    public static void clearAndFillText(By by, String value) {
        clearText(by);
        WaitElement.waitForElementVisible(by).sendKeys(value);
    }

    // ===== handle clear text =====
    public static void clearText(By by) {
        WaitElement.waitForElementVisible(by).sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.DELETE);
    }

    // ===== handle move mouse =====
    public static void moveToElement(By by) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(by)).perform();
    }

    // ===== handle drag and drop =====
    public static void dragAndDrop(By fromElement, By toElement) {
        Actions action = new Actions(DriverManager.getDriver());
        action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
    }

    // ===== handle scroll =====
    public static void scrollToElementToTop(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    }

    public static void scrollToElementToBottom(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }

    // ===== handle alert =====
    public static void alertAccept() {
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        DriverManager.getDriver().switchTo().alert().dismiss();
    }

    public static void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(tabNumber));
    }


    public static void reloadPage() {
        DriverManager.getDriver().navigate().refresh();
    }


//==============================================orangeHRM=================================================//

    public static void clearAndSendkey(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static String generateDate(String format, int offset) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(System.currentTimeMillis() + (long) offset * 86400000);
    }

    public static void setDate(WebElement element, int offset) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1]", element,
                generateDate("yyyy-MM-dd", offset));
    }

    public static void selectDropdownOptionByText(WebElement element, String text) {
        try {
            if (element.getTagName().equals("select")) {
                Select dropdown = new Select(element);
                dropdown.selectByVisibleText(text);
            } else {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectRadioButtonByText(List<WebElement> radioList, String text) {
        radioList.stream().filter(radio -> radio.getText().equals(text))
                .findFirst()
                .get()
                .click();
    }

    public static boolean checkFileDownloaded(String filePath) {
        File file = new File(filePath).getAbsoluteFile();
        return file.exists();
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath).getAbsoluteFile();
        if (file.exists()) {
            file.delete();
        }
    }

    public static void DownloadFile(String filePath,By by ){
        File checkExistFileDownload = new File(filePath).getAbsoluteFile();
        if (checkExistFileDownload.exists()) {
            checkExistFileDownload.delete();
        }
        WaitElement.waitForElementVisible(by);
        clickElement(by);
    }

}
