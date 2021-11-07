package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class NavbarElements extends Parent{
    public NavbarElements() {
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(id = "ctx-LoginBtn")
    private WebElement btnLogin; // Giriş Yap
    @FindBy(css = "span[class*='NavbarUsername']")
    private WebElement textNavbarUsername;

    public WebElement getTextNavbarUsername() {
        return textNavbarUsername;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }
}
