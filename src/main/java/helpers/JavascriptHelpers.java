package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptHelpers {
    private JavascriptExecutor jsExecutor;

    public JavascriptHelpers(JavascriptExecutor jsExecutor) {
        this.jsExecutor = jsExecutor;
    }

    public JavascriptHelpers() {
    }

    public void setJsExecutor(JavascriptExecutor jsExecutor) {
        this.jsExecutor = jsExecutor;
    }

    public void changeOpacity(WebElement element) {
        if (jsExecutor != null) {
            jsExecutor.executeScript("arguments[0].style.opacity='1'", element);
        } else {
            System.out.println("JsExecutor is not set. Please set JsExecutor before using this method.");
        }
    }

    public void changeMaxWidth(WebElement element) {
        if (jsExecutor != null) {
            jsExecutor.executeScript("arguments[0].style.maxWidth='20px'", element);
        } else {
            System.out.println("JsExecutor is not set. Please set JsExecutor before using this method.");
        }
    }

    public void changeWidth(WebElement element) {
        if (jsExecutor != null) {
            jsExecutor.executeScript("arguments[0].style.width='20px'", element);
        } else {
            System.out.println("JsExecutor is not set. Please set JsExecutor before using this method.");
        }
    }

    // Other helper methods...
}
