Feature: Cap Book SignUp 
Users can signUp to Cap Book system using this feature

Scenario: User wants to signUp
Given User is on SignUp Page
When  User enters his correct required details
Then   User is registered

Scenario: User wants to signUp
Given User is on SignUp Page
When  User enters his incorrect required details
Then   User is not registered message should appear