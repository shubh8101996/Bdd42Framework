Feature: Login 

Scenario Outline: Login with  credentials DDT

Given User Launch Chrome Browser
When User open URL "https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com"
And User enters Email as "<email>" and Password as "<password>"
And Click on Login button
Then Page title should be "My learning | W3Schools"
And close browser

Examples:
|email|password|
|shubhamshedge810@gmail.com|AdminShubham@123|
|shubham@gmail.com|shubham@123|