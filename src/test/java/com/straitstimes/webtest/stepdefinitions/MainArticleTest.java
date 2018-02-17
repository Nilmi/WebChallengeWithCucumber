package com.straitstimes.webtest.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.straitstimes.webtest.util.PropertyUtil;
import com.straitstimes.webtest.util.ValidationUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainArticleTest {

	private WebDriver driver;
	private WebDriverWait wait;
	private String heading;
	private String title;
	private WebElement mainImage;
	private WebElement mainArticleLink;
	private String emailAddress;

	/**
	 * Before Hook - Read the browser type, browser driver path from
	 * config.properties file Initialize the browser
	 * 
	 * @throws IOException
	 */
	@Before
	public void initialize_browser_navigate_to_url() throws IOException {
		// Read the browser type, browser driver path
		String browserName = PropertyUtil.getProperty("browser");
		String chromeDriverPath = PropertyUtil.getProperty("driver.chrome.path");
		String firefoxDriverPath = PropertyUtil.getProperty("driver.firefox.path");

		// Launch driver according to the browser name in property file
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}

		/*
		 * SafariDriver - DEPRECATED Therefore setting system properties in code not
		 * required instead requires manual installation of the extension prior to
		 * automation Also need to allow remote automation option in Safari browser to
		 * allow browser controlled by automated code.
		 */
		else if (browserName.equals("Safari")) {
			driver = new SafariDriver();
		}

	}

	/**
	 * Pre condition - Navigates to the http://www.straitstimes.com URL, close the
	 * advertisement
	 * 
	 * @throws IOException
	 */
	@Given("^user already navigated to straitstimes url$")
	public void user_already_navigated_to_straitstimes_url() throws IOException {
		// Read the URL
		String url = PropertyUtil.getProperty("url");
		String ad = PropertyUtil.getProperty("ad");
		String adClose = PropertyUtil.getProperty("ad.close");

		// go to the url
		driver.get(url);

		// switch to frame to close the ad
		driver.switchTo().frame(driver.findElement(By.xpath(ad)));
		driver.findElement(By.xpath(adClose)).click();
	}

	/**
	 * Verify the http://www.straitstimes.com main page title with expected title
	 * 
	 */
	@When("^title of the page is The Straits Times - Breaking News, Lifestyle & Multimedia News$")
	public void verify_title_of_straitstimes_main_page() {
		// get the title of the current page from driver
		title = driver.getTitle();

		// assert the title with expected title
		// read the expected value from config file
		String mainPageTitle = PropertyUtil.getProperty("main.page.title");
		Assert.assertEquals(mainPageTitle, title);
	}

	/**
	 * Click on LOGIN link
	 */
	@Then("^user click on login link$")
	public void user_click_on_login_link() {
		// explicit wait until the "LOGIN" link is clickable
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGIN")));

		// click on login
		driver.findElement(By.linkText("LOGIN")).click();
	}

	/**
	 * Asserts the login page title with expected title
	 */
	@Then("^directs user to login page$")
	public void directs_user_to_login_page() {
		// take the current page title from driver
		title = driver.getTitle();

		// Assert the actual tile with expected title
		// read the expected value from config file
		String loginPageTitle = PropertyUtil.getProperty("login.page.title");
		Assert.assertEquals(loginPageTitle, title);
	}

	/**
	 * Refer "Example" test data from feature file "Scenario Outline"
	 * 
	 * @param email
	 * @param password
	 * @throws IOException
	 */
	@Then("^user enter \"([^\"]*)\" and \"([^\"]*)\" click on sign-in button$")
	public void user_enter_username_and_password_click_on_sign_in_button(String email, String password)
			throws IOException {
		// Read the xpaths from property file
		String xpathEmail = PropertyUtil.getProperty("xpath.login.page.username");
		String xpathPassword = PropertyUtil.getProperty("xpath.login.page.password");
		String xpathSubmit = PropertyUtil.getProperty("xpath.login.page.submit");

		// store email in email variable for later assertions
		emailAddress = email;

		// enter username and password and click on sign-in button
		driver.findElement(By.xpath(xpathEmail)).sendKeys(email);
		driver.findElement(By.xpath(xpathPassword)).sendKeys(password);
		driver.findElement(By.xpath(xpathSubmit)).click();
	}

	/**
	 * Verify if user logged in successfully
	 * 
	 * @throws IOException
	 */
	@Then("^user login successfully$")
	public void user_login_successfully() throws IOException {
		// Read xpath from property file
		String xpathLoginEmail = PropertyUtil.getProperty("xpath.first.page.login.email");

		// explicit wait until logged user link can be located
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLoginEmail)));

		// verify user logged in successfully
		System.out.println("Logged email is --> " + driver.findElement(By.xpath(xpathLoginEmail)).getText());
		Assert.assertEquals(driver.findElement(By.xpath(xpathLoginEmail)).getText(), emailAddress);
	}

	/**
	 * Verify the main article image/video availability
	 * 
	 * @throws IOException
	 */
	@Then("^verify whether main article has a picture/video$")
	public void verify_whether_main_article_has_a_picture_video() throws IOException {
		// Read xpath from property file
		String xpathMainImage = PropertyUtil.getProperty("xpath.first.page.main.image");

		// Explicit wait until the main article image can be located
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathMainImage)));

		// locates the main article image
		mainImage = driver.findElement(By.xpath(xpathMainImage));

		System.out.print("Image is available --> " + ValidationUtil.checkImageValidity(mainImage.getAttribute("src")));

		// assert the return value from checkImageValidity method
		Assert.assertTrue(ValidationUtil.checkImageValidity(mainImage.getAttribute("src")));

	}

	/**
	 * Click on main article
	 * 
	 * @throws IOException
	 */
	@Then("^click on main article$")
	public void click_on_main_article() throws IOException {
		// Read xpaths from property file
		String xpathMainArticleHeading = PropertyUtil.getProperty("xpath.first.page.main.article.heading");
		String xpathMainArticleLink = PropertyUtil.getProperty("xpath.first.page.main.article.link");

		// Locate main article heading element
		WebElement headerElement = driver.findElement(By.xpath(xpathMainArticleHeading));

		// save the main article heading to heading variable for later assertions
		heading = headerElement.getText();
		System.out.println("Straits times main article heading is --> " + heading);

		// click on main article
		mainArticleLink = driver.findElement(By.xpath(xpathMainArticleLink));
		mainArticleLink.click();

	}

	/**
	 * Verify if user navigated to the main article
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Then("^verify that user navigated to main article$")
	public void verify_that_user_navigated_to_main_article() throws InterruptedException, IOException {
		String xpathMainArticlePageHeading = PropertyUtil.getProperty("xpath.main.article.page.heading");

		// explicit wait until main article heading element can be located
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathMainArticlePageHeading)));

		// assert the current page heading with main article page from previous page
		Assert.assertTrue(heading.equals(driver.findElement(By.xpath(xpathMainArticlePageHeading)).getText()));

	}

	/**
	 * Verify picture/video present in main article
	 * 
	 * @throws IOException
	 */
	@Then("^verify picture/video present in main article$")
	public void verify_picture_video_present_in_main_article() throws IOException {
		// Read xpath from property file
		String xpathMainArticleImage = PropertyUtil.getProperty("xpath.main.article.page.image");

		// Use JavascriptExecutor to verify whether image is present
		WebElement mainImage = driver.findElement(By.xpath(xpathMainArticleImage));

		boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				mainImage);

		// assert the current page heading with main article page from previous page
		Assert.assertTrue(ImagePresent);
	}

	/**
	 * After Hook - Close the browser after completing the test
	 */
	@After
	public void after_test_activities() {
		driver.quit();
	}

}
