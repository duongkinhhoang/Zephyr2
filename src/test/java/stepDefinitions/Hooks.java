package stepDefinitions;

import controls.Browser;
import drivers.DriverManager;
import drivers.TargetFactory;
import helpers.PropertiesFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import pages.comonpage.CommonPage;

import static data.Url.URL_LOGIN;
import static drivers.BrowserFactory.CHROME;
import static drivers.BrowserFactory.EDGE;

public class Hooks extends CommonPage {
    @Before
    public void setup() {
        PropertiesFile.setPropertiesFile();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(String.valueOf(CHROME)));
        DriverManager.setDriver(driver);
        Browser.openURL(URL_LOGIN.getUrl());
        loginPage().loginSuccess(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
    }

    @After
    public void closeDriver() {
        DriverManager.quit();
    }

}
