package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import runner.Constants;

import java.util.HashMap;

public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createDriver() {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("download.default_directory", Constants.DOWNLOAD_PATH);
            chromePreferences.put("profile.default_content_setting_values.media_stream_camera", 1);
            chromePreferences.put("profile.default_content_setting_values.media_stream_mic", 1);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-geolocation");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.setExperimentalOption("prefs", chromePreferences);

            return new ChromeDriver(chromeOptions);
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            HashMap<String, Object> edgePreferences = new HashMap<>();
            edgePreferences.put("download.default_directory", Constants.DOWNLOAD_PATH);
            edgePreferences.put("profile.default_content_setting_values.media_stream_camera", 1);
            edgePreferences.put("profile.default_content_setting_values.media_stream_mic", 1);

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--disable-geolocation");
            edgeOptions.addArguments("--no-sandbox");
            edgeOptions.setExperimentalOption("prefs", edgePreferences);

            return new EdgeDriver(edgeOptions);
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("media.navigator.permission.disabled", true);


            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setProfile(firefoxProfile);

            return new FirefoxDriver(firefoxOptions);
        }
    },
    SAFARI {
        @Override
        public WebDriver createDriver() {
            SafariOptions options = new SafariOptions();
            options.setAutomaticInspection(false);

            return new SafariDriver(options);
        }
    };

    public abstract WebDriver createDriver();
}
