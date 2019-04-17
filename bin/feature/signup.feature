Feature: signup scenario

Scenario: postive scenario for login functionality

Given : I on the login page
When : Entered the following credentials
|FirstName|LastName|Age|Gender|Email|City|Country|ph.no|Zip code|
|pradeep|kadarla|24|male|kadarla.pradeep4@gmail.com|vijayawada|India|89878787|521235|
|roger|federer|37|male|rogerFederer@yahoo.com|Basel|Switzerland|788904848|443738|
|Rafael|Nadal|34|male|rafaelNadal@yahoo.com|Madrid|spain|78899383848|335738|
|Novak|Djckovic|31|male|NovakDjockovic@yahoo.com|Serbia-city|Serbia|090298848|55738|
And : click on the login button
Then : i should be on the home page 