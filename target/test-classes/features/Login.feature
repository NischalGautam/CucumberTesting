Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on Login button in home page to land on Secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is sucessfully logged in
And Close all the Browsers

Examples:
|username				|password	|
|aryan_josh08@yahoo.com	|123456		|

