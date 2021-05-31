Feature: Login

@test
Scenario Outline: TC001_Login to application

	Given user is on login page
	When user enters <username> and <password>
	And clicks on submit button
	Then verify user is on home page
	
Examples:
|username|password|



	
