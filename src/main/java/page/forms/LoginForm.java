package page.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.HomePage;

public class LoginForm extends BasePage {

    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton = By.cssSelector("[onclick='logIn()']");

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        sendKeys(usernameField, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickSignIn() {
        click(loginButton);
    }

    public void login(String email, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogIn();
        setEmail(email);
        setPassword(password);
        clickSignIn();
    }
}
