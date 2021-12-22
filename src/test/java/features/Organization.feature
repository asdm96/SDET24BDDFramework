Feature: user can create, modify and delete organization

  Background: 
    ##Given I will launch "chrome" browser(this step taken care by HOOK class)
    Given Enter the url "http://localhost:8888/"
    And Login page is displayed enter the username "admin" and password "manager"
    And click on login

	@End2End
  Scenario Outline: As valid user create multiple organization
    When Home page is displayed click on organization link
    And click on create new organization
    And enter the organization name "<organization>" and click on save button
    Then verify organization "<organization>" created or not

    Examples: 
      | organization     |
      | Amazon           |
     
	@End2End @RegressionTest
  Scenario: As a valid user create a organization with organization, phone, website and employees
    When Home page is displayed click on organization link
    And click on create new organization
    And Enter organization name, phone, website and employees
      | organization name | phone | website        | employees |
      | Test Yantra       |  1234 | testyantra.com |      2000 |
    And click on save button
    Then verify the organization Name, phone, website and employees
    
    
    
    
    
    
    
    
    
    
    
    
    
    
