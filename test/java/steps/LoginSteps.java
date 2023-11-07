package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    // public WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {

        openBrowserAndLaunchApplication();
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException {

        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));

        sendText(loginPage.passwordTextField, ConfigReader.getPropertyValue("password"));


    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {

        click(loginPage.loginBtn);

    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {

        Assert.assertTrue(dashboardPage.welcomeAdminLocator.isDisplayed());

    }
}