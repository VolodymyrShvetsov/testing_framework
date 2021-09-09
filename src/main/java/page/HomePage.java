package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.forms.LoginForm;

public class HomePage extends BasePage {

    private final By logo = By.id("nava");
    private final By signIn = By.id("signin2");
    private final By login = By.id("login2");
    private final By userName = By.id("nameofuser");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUsername() {
        return getElement(userName).getText();
    }

    public void clickLogIn() {
        click(login);
    }


//    public void enterSearchItem(String itemName) {
//        sendKeys(searchTextBox, itemName);
//    }
//
//    public void enterSearchButton() {
//        click(searchButton);
//    }
//
//    public void searchItem(String itemName) {
//        enterSearchItem(itemName);
//        enterSearchButton();
//    }
}
