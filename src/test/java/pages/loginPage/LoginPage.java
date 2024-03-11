package pages.loginPage;

import controls.WebUI;
import org.openqa.selenium.By;
import pages.comonpage.CommonPage;


public class LoginPage extends CommonPage {
    By txt_Username = By.cssSelector("input[name='username'] ");
    By txt_Password = By.cssSelector("input[name='password']");
    By btn_Login = By.cssSelector("button[type=submit]");

    public void loginSuccess(String username, String password) {
        WebUI.enterText(txt_Username, username);
        WebUI.enterText(txt_Password, password);
        WebUI.clickElement(btn_Login);
    }
}
