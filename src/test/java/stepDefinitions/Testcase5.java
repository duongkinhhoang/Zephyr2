package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.comonpage.CommonPage;

import java.util.Map;

public class Testcase5 extends CommonPage {
    String filePath = "";

    @When("Navigate to view canidates page")
    public void navigateToViewCanidatesPage() {
        dashboardPage().clickViewCandidates();
    }

    @And("Click icon download")
    public void clickIconDownload(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String nameSearch = data.get("namesearch");
        String filePath = data.get("filepath");
        viewCandidates().clickItemDownLoad(nameSearch, filePath);
    }

    @Then("Verify file downloaded")
    public void verifyFileDownloaded() {
        viewCandidates().verifyFileExist(filePath);
    }
}
