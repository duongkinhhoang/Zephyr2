package pages.viewSystemUsersPage;


import controls.WebUI;

import org.openqa.selenium.*;

import pages.comonpage.CommonPage;
import org.junit.Assert;


public class ViewSystemUsersPage extends CommonPage {

    //Test case 1
    By resultsRow = By.xpath("//div[@role='cell'][2]");
    By txtUsername = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By btn_Search = By.xpath(" //button[text()=' Search ']");
    By btn_Add = By.xpath("//button[text()=' Add ' or text()=' Menambahkan ']");

    public void enterUsername(String userName) {
        WebUI.enterText(txtUsername, userName);
    }

    public void searchUsername() {
        WebUI.clickElement(btn_Search);
    }

    public void verifyUser(String userName) {
        String user = WebUI.getTextElement(resultsRow);
        Assert.assertEquals(user, userName);
    }

    public void checkUserExist(String userName) {
        enterUsername(userName);
        searchUsername();
        String user = WebUI.getTextElement(resultsRow);
        Assert.assertEquals(user, userName);
    }

    public void clickAdd() {
        WebUI.clickElement(btn_Add);
    }

}
