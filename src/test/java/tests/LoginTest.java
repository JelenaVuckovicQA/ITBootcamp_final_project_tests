package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTestPage{

    //Option:
    //@BeforeMethod
    //public void goToLogin() {
    //homePage.goToLogin();
    //}

    //assert: • Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void visitsTheLoginPageTest() {
        homePage.goToLogin();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrlR = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlR, expectedUrl);

    }

    @Test()
    public void checksInputTypesTest() {
        homePage.goToLogin();
        String expUsernameType = "email";
        String expPasswordType = "password";
        String actualUsernameType = loginPage.getUsernameF().getAttribute("type");
        String actualPasswordType = loginPage.getPasswordF().getAttribute("type");

        Assert.assertEquals(expUsernameType, actualUsernameType);
        Assert.assertEquals(expPasswordType, actualPasswordType);

    }


    @Test
    public void displaysErrorsWhenUserDoesNotExistTest() {

        Faker faker = new Faker();
        homePage.goToLogin();
        loginPage.loginMethod(faker.bothify("????##@gmail.com"), faker.funnyName().name());
        String actualResult = driver.findElement
                (By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();

        String expResult = "User does not exists";
        Assert.assertEquals(actualResult, expResult);

    }

    @Test
    public void displaysErrorsWhenPasswordWrongTest() {
        Faker faker = new Faker();
        homePage.goToLogin();
        String validUser = " admin@admin.com";
        loginPage.loginMethod(validUser, faker.funnyName().name());

        String actualResult = driver.findElement
                (By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();
        String expResult = "Wrong password";
        Assert.assertEquals(actualResult, expResult);

        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actualUrl);

    }

    @Test
    public void validLoginTest() {
        String validUser = " admin@admin.com";
        String validPassword = "12345";
        homePage.goToLogin();
        loginPage.loginMethod(validUser, validPassword);
        webDriverWait.until(ExpectedConditions.urlContains("/home"));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/home";

        Assert.assertEquals(actualUrl, expectedUrl);


    }


    @Test
    public void logoutTest() {
        String validUser = " admin@admin.com";
        String validPassword = "12345";

        homePage.goToLogin();
        loginPage.loginMethod(validUser, validPassword);
        webDriverWait.until(ExpectedConditions.urlContains("/home"));
        WebElement logoutBtn =
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));

        boolean isClickableLogout = logoutBtn.isEnabled();
        Assert.assertTrue(isClickableLogout);

        logoutBtn.click();

        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actualUrl);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expHomeUrlWhenLogout = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrlWhenLogout = driver.getCurrentUrl();
        Assert.assertEquals(expHomeUrlWhenLogout, actualUrlWhenLogout);

    }


}