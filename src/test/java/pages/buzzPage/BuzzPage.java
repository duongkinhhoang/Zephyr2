package pages.buzzPage;

import controls.WaitElement;
import controls.WebUI;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.junit.Assert;

public class BuzzPage {
    By btn_SharePhotos = By.xpath("//button[@class='oxd-glass-button'][1]" );
    By popup_SharePhotos = By.xpath("//div[@role='document']" );
    By txt_YourMind = By.xpath("(//textarea[@rows='1'])[2]" );
    By inputFileUpload = By.xpath("//input[@type='file']" );
    By clickShare = By.xpath("(//button[@type='submit'])[2]" );
    By post = By.xpath("(//div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]" );
    By textContentPost = By.xpath("(//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text'])[1]" );

    public void clickSharePhotos() {
        WebUI.clickElement(btn_SharePhotos);
    }

    public boolean verifyPopup() {
        return DriverManager.getDriver().findElement(popup_SharePhotos).isDisplayed();
    }

    public void verify_Content() {
        String verifyContent = WebUI.getAttributeElement(txt_YourMind, "placeholder" );
        Assert.assertEquals(verifyContent, "What's on your mind?" );
    }

    public void verifyPopupContent() {
        verifyPopup();
        verify_Content();
    }

    public void inputContent(String textcontent) {
        WebUI.enterText(txt_YourMind, textcontent);
    }

    public void uploadFile(String images) {
        DriverManager.getDriver().findElement(inputFileUpload).sendKeys(System.getProperty("user.dir" ) + images);
    }

    public void inputTextUploadFile(String textcontent, String images) {
        inputContent(textcontent);
        uploadFile(images);
    }

    public void clickShare() {
        WebUI.clickElement(clickShare);
    }

    public boolean verifyPost() {
        WaitElement.waitForElementVisible(post);
        return DriverManager.getDriver().findElement(post).isDisplayed();
    }

    public void verifyTextContentPost(String textcontent) {
        DriverManager.getDriver().navigate().refresh();
        WaitElement.waitForPageLoaded();
        String textContentPage = WebUI.getTextElement(textContentPost);
        Assert.assertEquals(textContentPage, textcontent);
    }

    public void verifyAfterDisplayShare(String textcontent) {
        verifyPost();
        verifyTextContentPost(textcontent);
    }
}
