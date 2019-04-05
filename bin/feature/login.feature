Feature: login funsctinality
Scenario Outline:Outline: postive scenrio of login functionality

Given user is on the login page
When enter the username "<username>" and password "<password>"

And Click on signin button
Then user should be navigated to home page succesfully

Examples:
|username|password|
|pradeep|kpradeep|
|roger|federer|
|Rafael|Nadal|



