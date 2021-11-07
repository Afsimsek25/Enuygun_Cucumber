package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.*;
import utilities.BaseDriver;

import java.util.List;

public class C002_BuyingPlaneTicket {

    NavbarElements navbarElements;
    LoginRegisterPopUpElements loginRegisterPopUpElements;
    MainPageElements mainPageElements;
    FlightsPage flightsPage;
    ReservationPage reservationPage;

    public C002_BuyingPlaneTicket(NavbarElements navbarElements, LoginRegisterPopUpElements loginRegisterPopUpElements,
                                  MainPageElements mainPageElements, FlightsPage flightsPage,
                                  ReservationPage reservationPage) {
        this.navbarElements = navbarElements;
        this.loginRegisterPopUpElements = loginRegisterPopUpElements;
        this.mainPageElements = mainPageElements;
        this.flightsPage = flightsPage;
        this.reservationPage = reservationPage;
    }

    @When("^User Find a Flights$")
    public void userFindAFlights() {
        String color = mainPageElements.getSheetUcakBileti().getCssValue("color");
        Assert.assertEquals(color, "rgba(83, 96, 94, 1)");
        List<WebElement> elements = BaseDriver.getDriver().findElements(By.cssSelector("#oneWayCheckbox:not(:checked)"));
        if (elements.size() != 0) {
            mainPageElements.clickFunction(mainPageElements.getCheckOneWayCheckbox());
        }
        mainPageElements.sendKeysFunction(mainPageElements.getInputOriginInput(), "Saw");
        mainPageElements.clickFunction(mainPageElements.getOptionSawAirport());
        mainPageElements.sendKeysFunction(mainPageElements.getInputDestinationInput(), "Esb");
        mainPageElements.clickFunction(mainPageElements.getOptionEsbAirport());
        mainPageElements.clickFunction(mainPageElements.getCalendarDepartureDate());
        mainPageElements.clickFunction(mainPageElements.getSelectedCalendarDay());
        mainPageElements.clickFunction(mainPageElements.getBtnBiletBul());
    }

    @Then("^The user should be able to choose the plane they want$")
    public void theUserShouldBeAbleToChooseThePlaneTheyWant() {
        flightsPage.waitUntilVisible(flightsPage.getBtnSelect());
        System.out.println(flightsPage.getListDirectFlightsSelectBtn().size());
        flightsPage.listSelection(flightsPage.getListDirectFlightsSelectBtn(),
                (int) ((Math.random() * flightsPage.getListDirectFlightsSelectBtn().size()) - 1));
        reservationPage.sendKeysFunction(reservationPage.getInputContactEmail(), "asimsekfurkan@yandex.com");
        reservationPage.sendKeysFunction(reservationPage.getInputContactCellPhone(), "5555555555");
        reservationPage.sendKeysFunction(reservationPage.getInputFirstName(), "Ahmet Furkan");
        reservationPage.sendKeysFunction(reservationPage.getInputLastName(), "SIMSEK");
        Select birthDay = new Select(reservationPage.getSelectBirthDay());
        birthDay.selectByValue("25");
        Select birthDateMonth = new Select(reservationPage.getSelectBirthDateMonth());
        birthDateMonth.selectByValue("12");
        Select selectBirthDateYear = new Select(reservationPage.getSelectBirthDateYear());
        selectBirthDateYear.selectByValue("1994");
        reservationPage.sendKeysFunction(reservationPage.getPublicId(), "63260105328");
        // gender select :D
        reservationPage.sendKeysFunction(reservationPage.getHealthCode(), "1812furkan");
        reservationPage.clickFunction(reservationPage.getBtnReservation());
    }

    @Then("^User must be able to buy tickets$")
    public void userMustBeAbleToBuyTickets() {
        reservationPage.verifyElement(reservationPage.getDialogWrongHesCode());
    }
}
