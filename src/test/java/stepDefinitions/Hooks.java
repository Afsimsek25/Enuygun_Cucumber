package stepDefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseDriver;
import utilities.ExcelUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(Scenario scenario)
    {
        System.out.println("Scenario has started");
        System.out.println("Scenario id="+ scenario.getId());
        System.out.println("Scenario name="+ scenario.getName());
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("Scenario has finished");
        System.out.println("Scenario result="+ scenario.getStatus());
        System.out.println("Scenario isFailed ?="+ scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy hh.mm");
        if (scenario.isFailed()) {

            TakesScreenshot screenshot = (TakesScreenshot) BaseDriver.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(ekranDosyasi,
                        new File("target/FailedScreenShots/"+ scenario.getId()+date.format(formatter)+".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ExcelUtilities.writeExcel("src/main/resources/ScenarioStatus.xlsx",scenario,BaseDriver.threadBrowserName.get(),date.format(formatter));
        BaseDriver.DriverQuit();
    }
}
