Feature: Orange Automation test

  @TestCaseKey=SCRUM-T2
  Scenario: Verify username successful
    When Navigate to view user page
    And Search by on the view user page
      | username | Alice.Duval |
#    And Click search on the view user page
#    Then Should see the name search below the results table


#  Scenario: Update information
#    When Navigate to view personal details page
#    And  Enter all information on the view personal details page
#      | title             | value      |
#      | firstname         | cristiano  |
#      | middlename        | ronaldo    |
#      | lastname          | jr         |
#      | nickname          | cr7        |
#      | employeeid        | 85116      |
#      | otherid           | 85080      |
#      | licensennumber    | 85081      |
#      | licenseexpirydate | 2023-01-22 |
#      | ssnnumber         | 85082      |
#      | sinnumber         | 85083      |
#      | datebirth         | 2023-02-22 |
#      | millitaryservice  | 15         |
#    And  Click save on the view personal details page
#    And  Verify the loading icon is displayed
#    And  Verify the successful update message is displayed
#    Then Verify all updated information is displayed correctly
#
#
#  Scenario: Upload images
#    When Navigate to view buzz page
#    And  Click share photos
#    And  Verify the Share Photos popup is displayed
#    And  Verify the textarea default display content
#    And  Enter all information and upload images then click Share
#      | textcontent | ATS Test Upload File                    |
#      | images      | \src\test\resources\files\imageTest.jpg |
#    Then Verify the shared content is displayed
#
#
#  Scenario:  Add user
#    When  Navigate to view user page after click add
#    And  Open new tab and navigate to the view user page
#      | url | https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers |
#    And Back to the first tab. Do Add a User with Employee Name
#      | employeename    | a           |
#      | username        | Alice.Duval |
#      | password        | admin123    |
#      | confirmpassword | admin123    |
#    And Go back to the second tab. Reload the page
#    Then Verify the user added in the first tab displayed
#
#
#  Scenario:  Download file on the view canidates page
#    When Navigate to view canidates page
#    And Click icon download
#      | namesearch | Charles                                  |
#      | filepath   | /src/test/resources/downloads/resume.pdf |
#    Then Verify file downloaded

















