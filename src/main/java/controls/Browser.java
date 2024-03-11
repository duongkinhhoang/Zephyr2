package controls;

import drivers.DriverManager;
import org.openqa.selenium.WindowType;

public class Browser {
    public static void openURL(String URL) {
        DriverManager.getDriver().get(URL);
        WaitElement.waitForPageLoaded();
    }

    public static void openNewTab() {
        // Opens a new tab and switches to new tab
        DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
    }


    public static void openNewWindow() {
        // Opens a new window and switches to new window
        DriverManager.getDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public static void reloadPage() {
        DriverManager.getDriver().navigate().refresh();
        WaitElement.waitForPageLoaded();
    }
}
