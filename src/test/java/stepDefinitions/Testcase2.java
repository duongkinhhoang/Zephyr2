package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.comonpage.CommonPage;

import java.util.Map;

public class Testcase2 extends CommonPage {
    String firstname = "";
    String middlename = "";
    String lastname = "";
    String nickname = "";
    String employeeid = "";
    String otherid = "";
    String licensennumber = "";
    String licenseexpirydate = "";
    String ssnnumber = "";
    String sinnumber = "";
    String datebirth = "";
    String millitaryservice = "";

    @When("Navigate to view personal details page")
    public void iClickMyInformationOnTheDashboardPage() {
        dashboardPage().clickViewPersonalDetails();
    }

    @And("Enter all information on the view personal details page")
    public void iEnterAllInformationOnTheViewPersonalDetailsPage(DataTable dataTable) {

        Map<String, String> dataInformation = dataTable.asMap(String.class, String.class);
        firstname = dataInformation.get("firstname");
        middlename = dataInformation.get("middlename");
        lastname = dataInformation.get("lastname");
        nickname = dataInformation.get("nickname");
        employeeid = dataInformation.get("employeeid");
        otherid = dataInformation.get("otherid");
        licensennumber = dataInformation.get("licensennumber");
        licenseexpirydate = dataInformation.get("licenseexpirydate");
        ssnnumber = dataInformation.get("ssnnumber");
        sinnumber = dataInformation.get("sinnumber");
        datebirth = dataInformation.get("datebirth");
        millitaryservice = dataInformation.get("millitaryservice");
        viewPersonalDetails().inputInformation(firstname, middlename, lastname, nickname, employeeid, otherid, licensennumber, licenseexpirydate, ssnnumber, sinnumber, datebirth, millitaryservice);
    }

    @And("Click save on the view personal details page")
    public void iClickSave() {
        viewPersonalDetails().clickSave();
    }

    @And("Verify the loading icon is displayed")
    public void verifyTheLoadingIconIsDisplayed() {
        viewPersonalDetails().iconLoad();
    }

    @And("Verify the successful update message is displayed")
    public void verifyTheSuccessfulUpdateMessageIsDisplayed() {
        viewPersonalDetails().notificationUpdate();
    }

    @Then("Verify all updated information is displayed correctly")
    public void verifyAllUpdatedInformationIsDisplayedCorrectly() {
        viewPersonalDetails().verifyInformationAfterUpdate(firstname, middlename, lastname, nickname, employeeid, otherid, licensennumber, licenseexpirydate, ssnnumber, sinnumber, datebirth, millitaryservice);
    }
}
