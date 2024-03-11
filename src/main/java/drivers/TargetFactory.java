package drivers;

import org.openqa.selenium.WebDriver;

public class TargetFactory {
    public WebDriver createInstance(String browser) {
        WebDriver webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        webdriver.manage().window().maximize();

        return webdriver;
    }
}

