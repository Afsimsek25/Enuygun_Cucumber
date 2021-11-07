package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class MainPageElements extends Parent {

    public MainPageElements() {
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Uçak Bileti']")
    private WebElement sheetUcakBileti;
    @FindBy(id = "OriginInput")
    private WebElement inputOriginInput;
    @FindBy(xpath = "//div[@class='suggestion_item']//span[text()='Sabiha Gökçen Havalimanı']")
    private WebElement optionSawAirport;
    @FindBy(id = "DestinationInput")
    private WebElement inputDestinationInput;
    @FindBy(xpath = "//div[@class='suggestion_item']//span[text()='Esenboğa Havalimanı']")
    private WebElement optionEsbAirport;
    @FindBy(css = "td[aria-label*='Selected']")
    private WebElement selectedCalendarDay;
    @FindBy(css = "#oneWayCheckbox:not(:checked)")
    private WebElement checkOneWayCheckbox;
    @FindBy(css = "div[class*='departureDate'] div[class*='SingleDatePicker_1']")
    private WebElement calendarDepartureDate;
    @FindBy(xpath = "//span[text()='Ucuz bilet bul']")
    private WebElement btnBiletBul;

    public WebElement getBtnBiletBul() {
        return btnBiletBul;
    }

    public WebElement getCalendarDepartureDate() {
        return calendarDepartureDate;
    }

    public WebElement getCheckOneWayCheckbox() {
        return checkOneWayCheckbox;
    }

    public WebElement getSelectedCalendarDay() {
        return selectedCalendarDay;
    }

    public WebElement getOptionEsbAirport() {
        return optionEsbAirport;
    }

    public WebElement getInputDestinationInput() {
        return inputDestinationInput;
    }

    public WebElement getOptionSawAirport() {
        return optionSawAirport;
    }

    public WebElement getInputOriginInput() {
        return inputOriginInput;
    }

    public WebElement getSheetUcakBileti() {
        return sheetUcakBileti;
    }
}
