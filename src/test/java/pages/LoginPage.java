package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {

    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    private By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");

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


    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

}