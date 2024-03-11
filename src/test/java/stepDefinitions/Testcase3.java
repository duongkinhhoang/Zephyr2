package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.comonpage.CommonPage;

import java.util.Map;

public class Testcase3 extends CommonPage {
    String textcontent = "";

    @When("Navigate to view buzz page")
    public void navigateToViewBuzzPage() {
        dashboardPage().clickViewBuzz();
    }

    @And("Click share photos")
    public void clickSharePhotos() {
        buzzPage().clickSharePhotos();
    }

    @And("Verify the Share Photos popup is displayed")
    public void verifyTheSharePhotosPopupIsDisplayed() {
        buzzPage().verifyPopup();
    }

    @And("Verify the textarea default display content")
    public void verifyTheTextareaSDefaultDisplayContentIsWhatSOnYourMind() {
        buzzPage().verify_Content();
    }

    @And("Enter all information and upload images then click Share")
    public void enterAllInformationAndUploadImagesThenClickShare(DataTable dataTable) {
        Map<String, String> dataInformation = dataTable.asMap(String.class, String.class);
        String textcontent = dataInformation.get("textcontent");
        String images = dataInformation.get("images");
        buzzPage().inputTextUploadFile(textcontent, images);
        buzzPage().clickShare();
    }

    @Then("Verify the shared content is displayed")
    public void verifyTheSharedContentIsDisplayed() {
        buzzPage().verifyAfterDisplayShare(textcontent);

    }
}
