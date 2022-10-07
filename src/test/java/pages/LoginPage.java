package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

        protected By email = By.id("email");
        protected By password = By.id("password");
        protected By loginBtn = By.xpath("//*[@id='app']/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");

        protected Faker faker = new Faker();

        protected By logoutBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span");


        public WebElement getEmail() {
            return getDriver().findElement(email);
        }

        public WebElement getPassword() {
            return getDriver().findElement(password);
        }

        public WebElement getLoginBtn() {
            return getDriver().findElement(loginBtn);
        }

        public Faker getFaker() {
            return faker;
        }

        public WebElement getLogoutBtn() {

            return getDriver().findElement(logoutBtn);
        }

        public void checkLogout() {
            List<WebElement> lista = getDriver().findElements(logoutBtn);
            if (lista.size() != 0) {
                getLogoutBtn().click();
            }
        }

        public void loginMethod (String email, String password) {
            getEmail().clear();
            getPassword().clear();
            getEmail().sendKeys(email);
            getPassword().sendKeys(password);
            getLoginBtn().click();
        }

        public void invalidEmail() {
            loginMethod(getFaker().internet().emailAddress(), "12345");
            if (!getEmail().equals("admin@admin.com")) {
                System.out.println("User does not exists");
            } else {
            }
        }
        public void invalidPassword() {
            loginMethod("admin@admin.com", getFaker().internet().password());
            if (!getPassword().equals("12345")) {
                System.out.println("Wrong password");
            } else {
            }
        }

    }