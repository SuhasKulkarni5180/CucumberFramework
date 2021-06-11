Feature: Feature to test Login functionality

@test
Scenario Outline: TC001_Check if user is able to login successfull

	Given user is on login page
	When user enters <username> and <password>
	And clicks on submit button
	Then verify user is on home page
	
	Examples:
	|username|password|
	|unofficialsuhaskulkarni@gmail.com|qwerty|

