Feature: Login functionality

Scenario: Login with valid credentials

Given User navigates to login page
When User enters valid email address "test0193@gmail.com"
And User enters valid password "test123"
And User clicks on Login button
Then User should be successfully logged in

Scenario: Login with invalid credentials

Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "123456789" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password

Given User navigates to login page
When User enters valid email address "test0193@gmail.com" 
And User enters invalid password "123456789" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password

Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "test123"
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentails

Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch  
 

