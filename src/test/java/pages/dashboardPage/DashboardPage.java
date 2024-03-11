package pages.dashboardPage;

import controls.WebUI;
import org.openqa.selenium.By;
import pages.comonpage.CommonPage;

public class DashboardPage extends CommonPage {

    By btn_viewUser = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    By btn_viewPersonalDetails = By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']");
    By btn_viewBuzz = By.xpath("//a[@href='/web/index.php/buzz/viewBuzz']");
    By btn_viewCandidates = By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");

    public void clickViewUser() {
        WebUI.clickElement(btn_viewUser);
    }

    public void clickViewPersonalDetails() {
        WebUI.clickElement(btn_viewPersonalDetails);
    }

    public void clickViewBuzz() {
        WebUI.clickElement(btn_viewBuzz);
    }

    public void clickViewCandidates() {
        WebUI.clickElement(btn_viewCandidates);
    }
}
