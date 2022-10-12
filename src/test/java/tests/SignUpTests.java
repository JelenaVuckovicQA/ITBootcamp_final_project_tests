package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BaseTestPage {


    @Test
    public void visitSignUpPageTest() {

        homePage.goToSignUp();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("signup"));
    }


    @Test
    public void checkInputTypesTest() {


        homePage.goToSignUp();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualEmail = signUpPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualPassword = signUpPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualPassword, "password");

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualConfirmPassword = signUpPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(actualConfirmPassword, "password");

    }

    @Test
    public void displayErrorsTest() {

        homePage.getSignUp().click();
        signUpPage.signUpMethod("Test Test", "admin@admin.com", "123654", "123654");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), "E-mail already exists");

    }

    @Test
    public void signUpTest() throws InterruptedException {
        homePage.goToSignUp();

        signUpPage.signUpMethod("Jelena Vuckovic", signUpPage.getFaker().internet().emailAddress(), "12346", "12346");
        Thread.sleep(5000);
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div/div[1]"));
        Assert.assertEquals(actualResult.getText(), "IMPORTANT: Verify your account");
    }
}