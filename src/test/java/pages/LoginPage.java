package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    private final By usernameField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    private final By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getUsernameF() {
        return getDriver().findElement(usernameField);
    }

    public WebElement getPasswordF() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public void loginMethod(String username, String password) {
        getUsernameF().sendKeys(username);
        getPasswordF().sendKeys(password);
        getLoginBtn().click();
    }

}