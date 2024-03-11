package pages.saveSystemUserPage;

import controls.Browser;
import controls.WaitElement;
import controls.WebUI;
import data.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.comonpage.CommonPage;

import static data.DataPlacement.*;


public class SaveSystemUserPage extends CommonPage {

    By drp_UserRole = By.xpath("(//div[text()='-- Select --'])[1]");
    By drp_UserRoleAdmin = By.xpath("//div[@role='listbox']/div[@role='option']/span[text()='Admin']");
    By drp_Status = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By drp_StatusEnabled = By.xpath("//div[@role='listbox']/div[@role='option']/span[text()='Enabled']");
    By txt_EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By item_EmployeeName = By.xpath("(//div[@role='listbox']/div[@role='option' and not(text()='Searching....')])[1]");
    By txt_Username = By.xpath("(//input[@autocomplete='off'])[1]");
    By txt_Password = By.xpath("(//input[@autocomplete='off'])[2]");
    By txt_ConfirmPassword = By.xpath("(//input[@autocomplete='off'])[3]");
    By btn_Save = By.xpath("//button[text()=' Save ']");
    By btn_Add = By.xpath("//button[text()=' Add ' or text()=' Menambahkan ']");


    public void openTabViewSystemUser(String url) {
        Browser.openNewTab();
        Browser.openURL(url);
        WebUI.switchToTab(0);
    }

    public void inputInfoAddUser(String employeeName,String userName,String password,String confirmPass) {
        //Select User Role
        WebUI.clickElement(drp_UserRole);
        WebUI.clickElement(drp_UserRoleAdmin);

        //Select Status
        WebUI.clickElement(drp_Status);
        WebUI.clickElement(drp_StatusEnabled);

        //Input Employee Name
        WebUI.enterText(txt_EmployeeName, employeeName);
        WaitElement.waitForElementVisible(item_EmployeeName);
        WebUI.clickElement(item_EmployeeName);

        //Input Username
        WebUI.enterText(txt_Username, userName);

        //Input Password
        WebUI.enterText(txt_Password, password);

        //Input Confirm Password
        WebUI.enterText(txt_ConfirmPassword, confirmPass);
    }

    public void clickSave() {
        WebUI.clickElement(btn_Save);
        WaitElement.waitForElementVisible(btn_Add);
    }

    public void backTabViewUser() {
        WebUI.switchToTab(1);
        WebUI.reloadPage();
    }
}
