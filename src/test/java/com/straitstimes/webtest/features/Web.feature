Feature: Login and view main article

# Scenario Outline allow executes the test scenario iteratively for test data provided in Examples section
Scenario Outline: Navigate to login page

Given user already navigated to straitstimes url
When title of the page is The Straits Times - Breaking News, Lifestyle & Multimedia News
Then user click on login link
Then directs user to login page
Then user enter "<username>" and "<password>" click on sign-in button
Then user login successfully
Then verify whether main article has a picture/video
Then click on main article
Then verify that user navigated to main article
Then verify picture/video present in main article

# username and password parameterized in Examples
Examples:
	| username				     | password |
	| wijerathna.nilmi@gmail.com	 | Test1234 |



