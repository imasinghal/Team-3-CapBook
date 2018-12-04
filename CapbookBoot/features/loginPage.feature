Feature: Cap Book Login Page
This feature is used by user to login

Scenario: User wants to Login 
Given User is on Login Page
When Users enters wrong credentials
Then  Incorrect Credentials message should display


Scenario: User wants to Login 
Given User is on Login Page
When Users enters correct credentials
Then  User should be logged in


