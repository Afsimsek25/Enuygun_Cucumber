package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class ReservationPage extends Parent{
    public ReservationPage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "contact_email")
    private WebElement inputContactEmail;
    @FindBy(id = "contact_cellphone")
    private WebElement inputContactCellPhone;
    @FindBy(id = "firstName_0")
    private WebElement inputFirstName;
    @FindBy(id = "lastName_0")
    private WebElement inputLastName;
    @FindBy(id="birthDateDay_0")
    private WebElement selectBirthDay;
    @FindBy(id="birthDateMonth_0")
    private WebElement selectBirthDateMonth;
    @FindBy(id="birthDateYear_0")
    private WebElement selectBirthDateYear;
    @FindBy(id = "publicId_0")
    private WebElement publicId;
    @FindBy(id = "healthCode_0")
    private WebElement healthCode;
    @FindBy(xpath = "//button[normalize-space()='Ödemeye ilerle']")
    private WebElement btnReservation;
    @FindBy(xpath = "//div[contains(text(),'HES kodunuz geçersiz')] ")
    private WebElement dialogWrongHesCode;

    public WebElement getDialogWrongHesCode() {
        return dialogWrongHesCode;
    }
    public WebElement getBtnReservation() {
        return btnReservation;
    }
    public WebElement getHealthCode() {
        return healthCode;
    }
    public WebElement getPublicId() {
        return publicId;
    }
    public WebElement getSelectBirthDateYear() {
        return selectBirthDateYear;
    }
    public WebElement getSelectBirthDateMonth() {
        return selectBirthDateMonth;
    }
    public WebElement getSelectBirthDay() {
        return selectBirthDay;
    }
    public WebElement getInputLastName() {
        return inputLastName;
    }
    public WebElement getInputFirstName() {
        return inputFirstName;
    }
    public WebElement getInputContactCellPhone() {
        return inputContactCellPhone;
    }
    public WebElement getInputContactEmail() {
        return inputContactEmail;
    }
}
