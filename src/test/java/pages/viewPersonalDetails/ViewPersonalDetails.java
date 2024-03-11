package pages.viewPersonalDetails;

import controls.Verify;
import controls.WaitElement;
import controls.WebUI;
import drivers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.comonpage.CommonPage;

import static data.DataPlacement.*;

public class ViewPersonalDetails extends CommonPage {
    By iconLoadPage = By.xpath("//form[@class='oxd-form']/div[@class='oxd-form-loader']/div[@class='oxd-loading-spinner-container']/div[@class='oxd-loading-spinner']");
    By txt_firstName = By.name("firstName");
    By txt_middleName = By.name("middleName");
    By txt_lastName = By.name("lastName");
    By txt_nickName = By.xpath("//*[text()='Nickname']/parent::div/following-sibling::div/input");
    By txt_employeeId = By.xpath("//*[text()='Employee Id' or text()='员工识别号']/parent::div/following-sibling::div/input");
    By txt_otherId = By.xpath("//*[text()='Other Id' or text()='其他识别号']/parent::div/following-sibling::div/input");
    By txt_driverLicenseNumber = By.xpath("//label[contains(text(),'License Number')]/parent::div/following-sibling::div/input");
    By txt_LicenseExpiryDate = By.xpath("//*[text()='License Expiry Date']/parent::div/following-sibling::div/descendant::div/input");
    By txt_SSNNumber = By.xpath("//*[text()='SSN Number']/parent::div/following-sibling::div/input");
    By txt_SINNumber = By.xpath("//*[text()='SIN Number']/parent::div/following-sibling::div/input");
    //By drpInfos = By.xpath("//div[contains(@class,'active')]");
    By drp_Nationality = By.xpath("//div[text()='Algerian' or text()='American' or text()='Afghan']");
    By drp_NationalityAlgerian = By.xpath("//div[@role='listbox']/div[@role='option']/span[text()='Afghan']");
    By drp_Marital = By.xpath("//div[text()='Single' or text()='Married']");
    By drp_MaritalMarried = By.xpath("//div[@role='listbox']/div[@role='option']/span[text()='Single']");
    By txt_DateBirth = By.xpath("//*[text()='Date of Birth']/parent::div/following-sibling::div/descendant::div/input");
    By rd_Gender = By.xpath("//div[@class='oxd-radio-wrapper']//descendant::label");
    By rd_GenderMale = By.xpath("//div[@class='oxd-radio-wrapper']//descendant::label/input[@type='radio' and @value='1']");
    By rd_GenderFemale = By.xpath("//div[@class='oxd-radio-wrapper']//descendant::label/input[@type='radio' and @value='2']");
    By txt_MilitaryService = By.xpath("//*[text()='Military Service']/parent::div/following-sibling::div/input");
    By btn_Save = By.xpath("(//button[@type='submit'])[1]");
    By not_SuccessfullyUpdated = By.xpath("//div[@id='oxd-toaster_1']");


    public void inputInformation(String firstname, String middlename, String lastname ,String nickname, String employeeid, String otherid, String licensennumber, String licenseexpirydate, String ssnnumber, String sinnumber, String datebirth,String millitaryservice ) {
        //Wait for the loading icon to disappear
        WaitElement.waitForElementVisible(iconLoadPage);
        WaitElement.waitForElementInVisible(iconLoadPage);

        //Input first name
        WebUI.clearAndFillText(txt_firstName, firstname);

        //Input middle Name
        WebUI.clearAndFillText(txt_middleName, middlename);

        //Input last Name
        WebUI.clearAndFillText(txt_lastName, lastname);

        //Input nick Name
        WebUI.clearAndFillText(txt_nickName, nickname);

        //Input EMPLOYEE ID
        WebUI.clearAndFillText(txt_employeeId, employeeid);

        //Input OTHER ID
        WebUI.clearAndFillText(txt_otherId, otherid);

        //Input LICENSE NUMBER
        WebUI.clearAndFillText(txt_driverLicenseNumber, licensennumber);

        //Input LICENSE EXPIRY DATE
        WebUI.clearAndFillText(txt_LicenseExpiryDate, licenseexpirydate);

        //Input SSN NUMBER
        WebUI.clearAndFillText(txt_SSNNumber, ssnnumber);

        //Input SIN NUMBER
        WebUI.clearAndFillText(txt_SINNumber, sinnumber);

        //Input DATE OF BIRTH
        WebUI.clearAndFillText(txt_DateBirth, datebirth);

        //Input MILITARY SERVICE
        WebUI.clearAndFillText(txt_MilitaryService, millitaryservice);

        //Select NATIONALLY
        WebUI.clickElement(drp_Nationality);
        WebUI.clickElement(drp_NationalityAlgerian);

        //Select MARITAL STATUS
        WebUI.clickElement(drp_Marital);
        WebUI.clickElement(drp_MaritalMarried);

    }

    public void clickSave() {
        WebUI.clickElement(btn_Save);
    }

    public boolean iconLoad() {
        return DriverManager.getDriver().findElement(iconLoadPage).isDisplayed();
    }

    public boolean notificationUpdate() {
        return DriverManager.getDriver().findElement(not_SuccessfullyUpdated).isDisplayed();
    }

    public void verifyInformationAfterUpdate(String firstname, String middlename, String lastname ,String nickname, String employeeid, String otherid, String licensennumber, String licenseexpirydate, String ssnnumber, String sinnumber, String datebirth,String millitaryservice) {
        String verifyFirstname = WebUI.getAttributeElement(txt_firstName, "value");
        String verifyMiddlename = WebUI.getAttributeElement(txt_middleName, "value");
        String verifyLastname = WebUI.getAttributeElement(txt_lastName, "value");
        String verifyNickname = WebUI.getAttributeElement(txt_nickName, "value");
        String verifyEmployee = WebUI.getAttributeElement(txt_employeeId, "value");
        String verifyOtherId = WebUI.getAttributeElement(txt_otherId, "value");
        String verifyLicenseNumber = WebUI.getAttributeElement(txt_driverLicenseNumber, "value");
        String verifyExpiryDate = WebUI.getAttributeElement(txt_LicenseExpiryDate, "value");
        String verifySSNNumber = WebUI.getAttributeElement(txt_SSNNumber, "value");
        String verifySINNumber = WebUI.getAttributeElement(txt_SINNumber, "value");
        String verifyNationality = WebUI.getTextElement(drp_Nationality);
        String verifyMaritalStatus = WebUI.getTextElement(drp_Marital);
        String verifyDateOfBirth = WebUI.getAttributeElement(txt_DateBirth, "value");
        String verifyMilitaryService = WebUI.getAttributeElement(txt_MilitaryService, "value");
        boolean verifyGender = Verify.verifyElementChecked(rd_GenderFemale);

        Assert.assertEquals(verifyFirstname, firstname);
        Assert.assertEquals(verifyMiddlename, middlename);
        Assert.assertEquals(verifyLastname, lastname);
        Assert.assertEquals(verifyNickname, nickname);
        Assert.assertEquals(verifyEmployee, employeeid);
        Assert.assertEquals(verifyOtherId, otherid);
        Assert.assertEquals(verifyLicenseNumber, licensennumber);
        Assert.assertEquals(verifyExpiryDate, licenseexpirydate);
        Assert.assertEquals(verifySSNNumber, ssnnumber);
        Assert.assertEquals(verifySINNumber, sinnumber);
        Assert.assertEquals(verifyDateOfBirth, datebirth);
        Assert.assertEquals(verifyMilitaryService, millitaryservice);
    }
}
