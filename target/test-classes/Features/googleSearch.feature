#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag0
Feature: Feature to google search

Background: Below are common steps
    Given browser is open

  @tag3
  Scenario: Validate google search is working
    
    When user enters the url "https://www.google.com"
    And user enters a text "What is GenAI" in seach box
    And hits enter
    Then user can search the text "Artificial Intelligence" in searched results page
