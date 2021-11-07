package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginRegisterPopUpElements;
import pages.NavbarElements;
import utilities.BaseDriver;
import utilities.ExcelUtilities;

import java.util.List;

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
        List<List<String>> loginData = ExcelUtilities.getListData("src/main/resources/LoginData.xlsx","loginData",2);
        navbarElements.clickFunction(navbarElements.getBtnLogin());
        loginRegisterPopUpElements.sendKeysFunction(loginRegisterPopUpElements.getInputEmail(),loginData.get(1).get(0));
        loginRegisterPopUpElements.sendKeysFunction(loginRegisterPopUpElements.getInputPassword(),loginData.get(1).get(1));
        loginRegisterPopUpElements.clickFunction(loginRegisterPopUpElements.getBtnSignIn());
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        navbarElements.verifyElementContainsText(navbarElements.getTextNavbarUsername(),"enuygunotomation");

    }
}
