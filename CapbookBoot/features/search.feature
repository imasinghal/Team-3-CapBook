Feature: Cap Book Search 
Users can Search in Cap Book system using this feature

Scenario: User wants to search
Given User clicks on Search
When  User enters name of profile whose details are to be searched
Then   User gets the search results if that profile exists

Scenario: User wants to search
Given User clicks on Search
When  User enters name of profile whose details are to be searched
Then   User gets 'O search result' if no profile exists