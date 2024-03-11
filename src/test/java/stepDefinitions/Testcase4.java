package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.comonpage.CommonPage;

import java.util.Map;

public class Testcase4 extends CommonPage {
    String userName = "";

    @When("Navigate to view user page after click add")
    public void navigateToTheViewUserPage() {
        dashboardPage().clickViewUser();
        viewSystemUsersPage().clickAdd();
    }

    @And("Open new tab and navigate to the view user page")
    public void openNewTabAndNavigateToTheViewUserPage(DataTable dataTable) {
        Map<String, String> dataUrl = dataTable.asMap(String.class, String.class);
        String url = dataUrl.get("url");
        saveSystemUserPage().openTabViewSystemUser(url);
    }

    @And("Back to the first tab. Do Add a User with Employee Name")
    public void backToTheFirstTabDoAddAUserWithEmployeeName(DataTable dataTable) {
        Map<String, String> dataUser = dataTable.asMap(String.class, String.class);
        String employeeName = dataUser.get("employeename");
        userName = dataUser.get("username") + (int) Math.floor(Math.random() * (50 - 2 + 1) + 2);
        String password = dataUser.get("password");
        String confirmPass = dataUser.get("confirmpassword");
        saveSystemUserPage().inputInfoAddUser(employeeName, userName, password, confirmPass);
        saveSystemUserPage().clickSave();
    }

    @And("Go back to the second tab. Reload the page")
    public void goBackToTheSecondTabReloadThePage() {
        saveSystemUserPage().backTabViewUser();
    }

    @Then("Verify the user added in the first tab displayed")
    public void verifyTheUserAddedInTheFirstTabDisplayed() {
        viewSystemUsersPage().checkUserExist(userName);
    }
}
