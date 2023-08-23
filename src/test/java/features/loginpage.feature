Feature: Login Functionality for Facebook

  As a user of the Facebook website
  I want to be able to log in with my account
  So that I can access my account-related features

  Background:
    Given I am on the Facebook login page
#@setA
  ##Given I have entered a valid username and password
   #When I click on the login button
  # Then I should be logged in successfully
#@setB
  #Scenario Outline: Unsuccessful login with invalid or empty credentials
  #  Given I have entered invalid "<username>" and "<password>"
    #When I click on the login button
   # Then I should see an error message indicating "<error_message>"
#
   # Examples:
  #    | username          | password        | error_message               |
   #   | 898885552265688 | invalidPassword |Find your account and log in.|
    #  | 4455522665885   | validPassword   |Find your account and log in.|
     # | 222554855663634 | abccc           |Find your account and log in.|
                                            #
#@setC
  #Scenario: Navigating to the forgotten password page
    #When I click on the "Forgotten Password" link
    #Then I should be redirected to the password reset page
    #
    
    
    
    Scenario: Create facebook account
    When I click on create new account
    And I will fill new account createpage
   
    
    

    
   
    
    