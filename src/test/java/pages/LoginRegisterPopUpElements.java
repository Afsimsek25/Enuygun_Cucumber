package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class LoginRegisterPopUpElements extends Parent {
    public LoginRegisterPopUpElements() {
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(css = "form[data-form-type='login'] input[name='_email']")
    private WebElement inputEmail; // E-Mail input alanı
    @FindBy(css = "form[data-form-type='login'] input[name='_password']")
    private WebElement inputPassword; // Password input alanı
    @FindBy(xpath = "//span[text()='Giriş Yap']")
    private WebElement btnSignIn;

    public WebElement getBtnSignIn() {
        return btnSignIn;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }
}
