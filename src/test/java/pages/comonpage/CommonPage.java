package pages.comonpage;


import pages.buzzPage.BuzzPage;
import pages.dashboardPage.DashboardPage;
import pages.loginPage.LoginPage;
import pages.viewCandidates.ViewCandidates;
import pages.viewPersonalDetails.ViewPersonalDetails;
import pages.viewSystemUsersPage.ViewSystemUsersPage;
import pages.saveSystemUserPage.SaveSystemUserPage;

public class CommonPage {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ViewPersonalDetails viewPersonalDetails;
    private ViewSystemUsersPage viewSystemUsersPage;
    private BuzzPage buzzPage;
    private SaveSystemUserPage saveSystemUserPage;
    private ViewCandidates viewCandidates;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ViewSystemUsersPage viewSystemUsersPage() {
        if (viewSystemUsersPage == null) {
            viewSystemUsersPage = new ViewSystemUsersPage();
        }
        return viewSystemUsersPage;
    }

    public ViewPersonalDetails viewPersonalDetails() {
        if (viewPersonalDetails == null) {
            viewPersonalDetails = new ViewPersonalDetails();
        }
        return viewPersonalDetails;
    }
    public BuzzPage buzzPage(){
        if(buzzPage==null){
            buzzPage=new BuzzPage();
        }
        return buzzPage;
    }
    public SaveSystemUserPage saveSystemUserPage(){
        if (saveSystemUserPage==null){
            saveSystemUserPage=new SaveSystemUserPage();
        }
        return saveSystemUserPage;
    }

    public ViewCandidates viewCandidates(){
        if(viewCandidates==null){
            viewCandidates=new ViewCandidates();
        }
        return viewCandidates;
    }

}
