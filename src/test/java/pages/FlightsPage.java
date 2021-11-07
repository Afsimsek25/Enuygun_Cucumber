package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

import java.util.List;

public class FlightsPage extends Parent {
    public FlightsPage() {
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@class='summary-transit direct']/../..//button")
    private List<WebElement> listDirectFlightsSelectBtn;
    @FindBy(css = "div[class='flight-summary-select']")
    private WebElement btnSelect;

    public WebElement getBtnSelect() {
        return btnSelect;
    }
    public List<WebElement> getListDirectFlightsSelectBtn() {
        return listDirectFlightsSelectBtn;
    }
}
