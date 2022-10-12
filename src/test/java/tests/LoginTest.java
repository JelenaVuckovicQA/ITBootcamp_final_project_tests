package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTestPage {

    //Option:
    //@BeforeMethod
    //public void goToLogin() {
    //homePage.goToLogin();
    //}


    @Test
    //assert: • verify that page URL containts "/login" route
    public void visitsTheLoginPageTest() {
        homePage.goToLogin();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/login"));

    }

    @Test()
    //Test #2: Checks input types
    //assert:
    //verify that email field has an atribute type value: "email"
    // verify that password field has an atribute type value: "password"

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
    //Test #3: Displays errors when user does not exist

    public void displaysErrorsWhenUserDoesNotExistTest() {

        homePage.goToLogin();
        loginPage.loginMethod(faker.bothify("????##@gmail.com"), faker.funnyName().name());
        String actualResult = driver.findElement(By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();

        String expResult = "User does not exists";
        Assert.assertEquals(actualResult, expResult);

    }

    @Test

    //Input data:
    // email: admin@admin.com
    // password: fake password
    //asssert:
    //Verify that notification contains "Wrong password" message
    //Verify that url contains "/login" route

    public void displaysErrorsWhenPasswordWrongTest() {
        homePage.goToLogin();
        String validUser = " admin@admin.com";
        loginPage.loginMethod(validUser, faker.funnyName().name());

        String actualResult = driver.findElement(By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();
        String expResult = "Wrong password";
        Assert.assertEquals(actualResult, expResult);

        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actualUrl);

    }

    @Test
    //Input data:
    //email: admin@admin.com
    //password: 12345
    //asssert:
    //Verify that url contains "/home" route
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
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));

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