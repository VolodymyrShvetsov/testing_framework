package test;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.HomePage;
import page.CartPage;
import page.forms.LoginForm;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.testng.Assert.assertEquals;
import static util.driver.DriverHolder.getDriver;

@Epic("Manage Account")
@Feature("Login")
public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginForm loginForm;

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeMethod() {
        homePage = new HomePage(getDriver());
        loginForm = new LoginForm(getDriver());
    }

    @Test(description = "Verify that a valid user can login to the application")
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    public void testValidLogin() {
        loginForm.login("qa123","123456");
        assertEquals(new HomePage(getDriver()).getLoggedInUsername(), "Welcome qa123");
    }

    @Test(description = "Verify that an invalid user cannot login to the application")
    @Severity(CRITICAL)
    @Description("Verify that an invalid user cannot login to the application")
    @Story("As a user I should be able to login to the application")
    public void testInvalidLogin() {
        loginForm.login("qa123","123");
        assertEquals(getDriver().switchTo().alert().getText(), "Wrong password.");
    }
}
