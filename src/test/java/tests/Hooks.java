package tests;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import tests.driver.DriverHelper;

import java.net.MalformedURLException;

public class Hooks {

    private DriverHelper driverHelper = new DriverHelper();

    @Before
    public void setUp() throws MalformedURLException {
        driverHelper.openBrowser();
        driverHelper.navigateTo(System.getProperty("url"));
        driverHelper.maxBrowser();
        driverHelper.applyImpWait();
        driverHelper.handleCookeis();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            driverHelper.embedScreenshot(scenario);
        }
        driverHelper.closeBrowser();
    }
}
