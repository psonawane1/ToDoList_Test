
Feature: Test ToDOList functions
  In order to remember the things I want to do, as a ToDo MVC user, I want to manage my todo list


	Scenario: Verify page title on todolist page
    Given I navigate to the ToDOList page
    When  Verify page title
    Then  close the browser
	
	Scenario: Verify caption on todolist page
    Given I navigate to the ToDOList page
    When I Verify caption on page
    Then  close the browser  
    
	Scenario: Drop down should not be visible when no tasks are added
    Given I navigate to the ToDOList page
    When I search for drop down 
    Then I verify no tasks are added
    And close the browser
   
  Scenario: Verify all links working in todo list
    Given I navigate to the ToDOList page
    When I enter activities name 
    And  I validate activities listed
    Then I should see tasks listed under all, active and completed links
    Then I should see clear all link besides completed link only  
    And  close the browser

 	Scenario: Complete a single task added in the todo list
  	Given I navigate to the ToDOList page
  	And   I enter activities name
  	When  I click on the checkbox of the task
  	Then  I should see reduced todo task at bottom of list along with clear task link enabled
  	Then  I should see completed task added to completed tasks
  	And   close the browser
    
   
