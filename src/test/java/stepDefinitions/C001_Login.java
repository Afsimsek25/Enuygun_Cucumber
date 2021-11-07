package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginRegisterPopUpElements;
import pages.NavbarElements;
import utilities.BaseDriver;

public class C001_Login {
    WebDriver driver;

    NavbarElements navbarElements;
    LoginRegisterPopUpElements loginRegisterPopUpElements;

    public C001_Login(NavbarElements navbarElements, LoginRegisterPopUpElements loginRegisterPopUpElements) {
        this.navbarElements = navbarElements;
        this.loginRegisterPopUpElements = loginRegisterPopUpElements;
    }

    @Given("^Navigate to Enuygun\\.com$")
    public void navigateToEnuygunCom() {
        driver = BaseDriver.getDriver();
        driver.get("https://www.enuygun.com/");
        driver.manage().window().maximize();

    }

    @When("^Enter username and password and click login button$")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        navbarElements.clickFunction(navbarElements.getBtnLogin());
        loginRegisterPopUpElements.sendKeysFunction(loginRegisterPopUpElements.getInputEmail(),"enuygunotomation@mail.com.tr");
        loginRegisterPopUpElements.sendKeysFunction(loginRegisterPopUpElements.getInputPassword(),"123456");
        loginRegisterPopUpElements.clickFunction(loginRegisterPopUpElements.getBtnSignIn());
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        navbarElements.verifyElementContainsText(navbarElements.getTextNavbarUsername(),"enuygunotomation");

    }
}
