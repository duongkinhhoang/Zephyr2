package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.comonpage.CommonPage;


import java.util.Map;


public class Testcase1 extends CommonPage {

    String userName = "";

    @When("Navigate to view user page")
    public void navigateToViewUserPage() {
        dashboardPage().clickViewUser();
    }

    @And("Search by on the view user page")
    public void searchByUsernameOnTheViewUserPage(DataTable dataTable) {
        Map<String, String> dataInformation = dataTable.asMap(String.class, String.class);
        userName = dataInformation.get("username");
        viewSystemUsersPage().enterUsername(userName);
    }

    @And("Click search on the view user page")
    public void clickSearch() {
        viewSystemUsersPage().searchUsername();
    }

    @Then("Should see the name search below the results table")
    public void shouldSeeTheNameUsernameSearchBelowTheResultsTable() {
        viewSystemUsersPage().verifyUser(userName);
    }


}
