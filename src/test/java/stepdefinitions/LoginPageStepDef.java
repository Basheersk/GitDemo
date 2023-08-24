package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageStepDef {
	

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
    	System.setProperty("webdriver.chrome.driver","C://Program Files//Drivers//chromeDriver//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        
            driver.quit();
        
    }


    @Given("I am on the Facebook login page")
    public void i_am_on_the_facebook_login_page() {
        driver.get("https://www.facebook.com/");
        loginPage = new LoginPage(driver);

    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail("8519981566");
        loginPage.enterPassword("Amma@143143");
        System.out.println("ABC");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        System.out.println("ABC");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
        System.out.println("ABC");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
    	 Assert.assertTrue(loginPage.getAfterLoginPageUrl().contains("sk=welcome"));
        //Assert.assertEquals(loginPage.checkFindFriendskLocator(), true);
    }



    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertEquals( driver.findElement(By.xpath("//a[normalize-space()='Find your account and log in.']")).isDisplayed(), true);
    }

    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_forgotten_password_link() {
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        // Assert that the current URL contains the password reset page route
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("facebook_login&from_login_screen=0"));
    }
    
    @When("I click on create new account")
    public void i_click_on_create_new_account() {
    driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
        
    }

    @Then("I will fill new account createpage")
    public void i_will_find_new_account_createpage() throws InterruptedException {
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Basheer");
    	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sk");
    	
    	
    	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Basheer@gmail.com");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Basheer@123");
    	
   
    	Select date = new Select(driver.findElement(By.id("day")));
    	Thread.sleep(3000);
    	date.selectByVisibleText("15");
    	System.out.println("ABC");
    	
    	Select month= new Select(driver.findElement(By.id("month")));
    	Thread.sleep(3000);
    	month.selectByVisibleText("Apr");
    	// xx
    	month.selectByVisibleText("Aug");
    	month.selectByVisibleText("Jan");
    	System.out.println("ABC");
    	
    	
    	Select year= new Select(driver.findElement(By.id("year")));
    	Thread.sleep(3000);
    	year.selectByVisibleText("1995");
    	year.selectByVisibleText("1996");
    	year.selectByVisibleText("1997");
    	
    	//from person x
    	year.selectByVisibleText("2000");
    	year.selectByVisibleText("2020");
    	System.out.println("ABC");
    	
    	
    	
    	
    	driver.findElement(By.xpath("//label[contains(text(),'Male')]/following::input[@name='sex'][1]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("(//button[contains(text(),'Sign Up')])[1]")).click();
    	
    	
    	 	
        
    	
    	
    }
    @Then("I validate new created new account {string}")
    public void iVerifyCreatedNewAccount(String val) {
    	boolean isdispalyed= driver.findElement(By.xpath("(//button[contains(text(),'Sign Up')])[1]")).isDisplayed();
    	Assert.assertTrue(isdispalyed);
    }
    

}
