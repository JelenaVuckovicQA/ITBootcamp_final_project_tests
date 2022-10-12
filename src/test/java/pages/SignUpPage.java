package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    protected By email = By.id("email");
    protected By password = By.id("password");
    protected By confirmPassword = By.id("confirmPassword");
    protected By name = By.id("name");
    protected By signMeUp = By.xpath("//*[@id='app']/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");

    Faker faker = new Faker();

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getSignMeUp() {
        return getDriver().findElement(signMeUp);
    }

    public Faker getFaker() {
        return faker;
    }

    public void signUpMethod(String name, String email, String password, String confirmPassword) {
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getSignMeUp().click();
    }

}