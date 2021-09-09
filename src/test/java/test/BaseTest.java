package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import util.driver.DriverFactory;

import static util.PropertyFileReader.getProperty;
import static util.driver.DriverHolder.*;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        setDriver(DriverFactory.getNewDriverInstance(getProperty("browser")));
        getDriver().manage().window().maximize();
        getDriver().get(getProperty("application_url"));
    }

    @AfterTest(alwaysRun = true)
    public void after() {
        if (getDriver() != null && getSessionId() != null) {
            getDriver().close();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        getSessionId();
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
