package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTestPage {


    @Test
    public void visistsTheLoginPage() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homePage.goToLoginpage();

        String actualResult = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void checksInputTypes () {
        String expectedResult = "email";

        homePage.goToLoginpage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String actualResult = loginPage.getUsername().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);

    }

}
