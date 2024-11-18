@tag
Feature: Feature to test login functionality

# https://admin-demo.nopcommerce.com/login: this is the example url that can be used for login
# user: admin@yourstore.com, pass: admin
  @tag1
  Scenario Outline: Check user is logged in successfully
    When user enters <userid> and <password>
    And cliks on login button "button1"
    Then user is navigated to home page

    Examples: 
      | userid | password |
      | test   | pass1    |
      | test1  | pass2    |

  