Feature: User Login feature

	@SmokeTest
  Scenario: As a valid user I want to login to vtiger using username and password
    ##Given I will launch browser
    Given Enter the url
    When Login page is displayed and I will enter username and password
    And click on login button
    Then I will verify it will navigating to home page or not

	@SmokeTest
  Scenario: As valid user i want login to app using valid username and password
    ##Given I will launch "chrome" browser
    Given Enter the url "http://localhost:8888/"
    When Login page is displayed enter the username "admin" and password "manager"
    And click on login
    Then Verify the title "    Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"

	@RegressionTest 
  Scenario Outline: As  valid user i will enter multiple set of invalid user credentials
   ## Given I will launch "chrome" browser
    Given Enter the url "http://localhost:8888/"
    When login page is displayed enter username "<username>" and password "<password>"
    And click on login
    Then verify the error message "You must specify a valid username and password."

    Examples: 
      | username | password |
      | abc      | manager  |
      | admin    | abc      |
      | abc123   | xyz      |
