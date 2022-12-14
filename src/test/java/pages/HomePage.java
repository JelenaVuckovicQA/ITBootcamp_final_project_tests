package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    protected By login = By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[3]/span");
    protected By signUp = By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[4]/span");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogin() {
        return getDriver().findElement(login);
    }

    public WebElement getSignUp() { return getDriver().findElement(signUp); }

    public void goToLogin() { getLogin().click(); }

    public void goToSignUp() {
        getSignUp().click();
    }
}



