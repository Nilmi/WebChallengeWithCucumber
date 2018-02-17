$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/straitstimes/webtest/features/Web.feature");
formatter.feature({
  "line": 1,
  "name": "Login and view main article",
  "description": "",
  "id": "login-and-view-main-article",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "# Scenario Outline allow executes the test scenario iteratively for test data provided in Examples section"
    }
  ],
  "line": 4,
  "name": "Navigate to login page",
  "description": "",
  "id": "login-and-view-main-article;navigate-to-login-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user already navigated to straitstimes url",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "title of the page is The Straits Times - Breaking News, Lifestyle \u0026 Multimedia News",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user click on login link",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "directs user to login page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" click on sign-in button",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user login successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "verify whether main article has a picture/video",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "click on main article",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "verify that user navigated to main article",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "verify picture/video present in main article",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 17,
      "value": "# username and password parameterized in Examples"
    }
  ],
  "line": 18,
  "name": "",
  "description": "",
  "id": "login-and-view-main-article;navigate-to-login-page;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 19,
      "id": "login-and-view-main-article;navigate-to-login-page;;1"
    },
    {
      "cells": [
        "wijerathna.nilmi@gmail.com",
        "Test1234"
      ],
      "line": 20,
      "id": "login-and-view-main-article;navigate-to-login-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1371024516,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Navigate to login page",
  "description": "",
  "id": "login-and-view-main-article;navigate-to-login-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user already navigated to straitstimes url",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "title of the page is The Straits Times - Breaking News, Lifestyle \u0026 Multimedia News",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user click on login link",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "directs user to login page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user enter \"wijerathna.nilmi@gmail.com\" and \"Test1234\" click on sign-in button",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user login successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "verify whether main article has a picture/video",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "click on main article",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "verify that user navigated to main article",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "verify picture/video present in main article",
  "keyword": "Then "
});
formatter.match({
  "location": "MainArticleTest.user_already_navigated_to_straitstimes_url()"
});
formatter.result({
  "duration": 16349319708,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.verify_title_of_straitstimes_main_page()"
});
formatter.result({
  "duration": 48225007,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.user_click_on_login_link()"
});
formatter.result({
  "duration": 6118828366,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.directs_user_to_login_page()"
});
formatter.result({
  "duration": 5270316,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wijerathna.nilmi@gmail.com",
      "offset": 12
    },
    {
      "val": "Test1234",
      "offset": 45
    }
  ],
  "location": "MainArticleTest.user_enter_username_and_password_click_on_sign_in_button(String,String)"
});
formatter.result({
  "duration": 5952253098,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.user_login_successfully()"
});
formatter.result({
  "duration": 6383312715,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.verify_whether_main_article_has_a_picture_video()"
});
formatter.result({
  "duration": 1041905944,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.click_on_main_article()"
});
formatter.result({
  "duration": 3660642120,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.verify_that_user_navigated_to_main_article()"
});
formatter.result({
  "duration": 54012990,
  "status": "passed"
});
formatter.match({
  "location": "MainArticleTest.verify_picture_video_present_in_main_article()"
});
formatter.result({
  "duration": 29609043,
  "status": "passed"
});
formatter.after({
  "duration": 112697597,
  "status": "passed"
});
});