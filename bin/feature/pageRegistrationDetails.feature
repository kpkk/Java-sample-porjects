Feature: sign up details

Scenario: postive scenrio for user registration
Given : user on the login page
When : Entered the following details
|FirstName|LastName|
|admin|adminstartor|
|abc|def|
|roger|federer|
|rafael|nadal|
|Novak|Djockovic|
And : click on enter
Then : account should be created succesfully
 