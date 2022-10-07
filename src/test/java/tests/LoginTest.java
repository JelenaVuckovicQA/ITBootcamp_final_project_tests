package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTestPage{

    @BeforeMethod
    public void goToLogin() {
        homePage.goToLogin();
    }

    @AfterMethod
    public void logout() {
        loginPage.checkLogout();
        }


    @Test
    public void visitLoginPageTest() {

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void inputType() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedResult1 = "email";
        String actualResult1 = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String exptectedResult2 = "password";
        String actualResult2 = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult2, exptectedResult2);
    }

    @Test
    public void invalidUsername() {

        Faker faker = new Faker();

        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        loginPage.loginMethod(fakeEmail, fakePassword);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), "User does not exists");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void invalidPassword() {

        loginPage.invalidPassword();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), "Wrong password");

    }

    @Test
    public void loginUserTest () throws InterruptedException {

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.loginMethod("admin@admin.com", "12345");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        loginPage.getLogoutBtn().click();
    }

    @Test
    public void logOutTest() throws InterruptedException {

        loginPage.loginMethod("admin@admin.com", "12345");
        String expectedResult = "LOGOUT";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
        loginPage.getLogoutBtn().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualRes = driver.getCurrentUrl();
        Assert.assertTrue(actualRes.contains("login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}