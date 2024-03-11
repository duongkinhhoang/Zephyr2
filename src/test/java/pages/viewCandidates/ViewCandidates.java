package pages.viewCandidates;

import controls.WaitElement;
import controls.WebUI;
import org.openqa.selenium.By;
import runner.Constants;
import runner.FileUtils;

import static data.DataPlacement.*;

public class ViewCandidates {
    By btn_Download = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space']/i[@class='oxd-icon bi-download'])[1]");
    By txt_CandidateName = By.xpath("//input[@placeholder='Type for hints...']");
    By item_CandidateName = By.xpath("(//div[@role='listbox']/div[@role='option' and not(text()='Searching....')])[1]");
    By btn_Search = By.xpath("//button[text()=' Search ']");

    public void searchName(String nameSearch) {
        WebUI.enterText(txt_CandidateName, nameSearch);
        WaitElement.waitForElementVisible(item_CandidateName);
        WebUI.clickElement(item_CandidateName);
        WebUI.clickElement(btn_Search);
    }

    public void clickItemDownLoad(String nameSearch,String filePath) {
        searchName(nameSearch);
        WebUI.DownloadFile(filePath, btn_Download);
    }

    public void verifyFileExist(String filePath) {
        FileUtils.verifyFileEqualsInDownloadDirectory(filePath);
    }
}
