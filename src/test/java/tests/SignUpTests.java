package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BaseTestPage {


@BeforeMethod
public void signUp() {
    homePage.goToSignUp();

}
    @Test
    public void visitSignUpPageTest() {
        //Visits the signup page
        //assert:
        //Verifikovati da se u url-u stranice javlja /signup ruta


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedResult = "/signup";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/signup"));
    }

    @Test
    public void checkInputTypesTest() {
        //Verifikovati da polje za unos emaila za atribut type ima vrednost
        //email
        //Verifikovati da polje za unos lozinke za atribut type ima vrednost
        //password
        //Verifikovati da polje za unos lozinke za potvrdu za atribut type ima
        //vrednost password

        String expectedResult = "email";
        String actualResult = signUpPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String exptecteResult1 = "password";
        String actualResult1 = signUpPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult1, exptecteResult1);

        String expectedResult2 = "password";
        String actualResult2 = signUpPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);


    }

    @Test
    public void displayErrorsTest() {
        //Podaci:
        //name: Test Test
        //email: admin@admin.com
        //password: 123654
        //confirm password: 123654
        //assert:
        //Verifikovati da greska sadrzi poruku E-mail already exists
        //Verifikovati da se u url-u stranice javlja /signup ruta

        String exptectedResult = "E-mail already exists";

        signUpPage.signUpMethod("Test Test", "admin@admin", "123654", "123654");

        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(actualResult.getText(), exptectedResult);

        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button/span"));
        closeBtn.click();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        homePage.goToSignUp();;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String exptectedResult1 = "/signup";
        String actualResult1 = driver.getCurrentUrl().toString();
        Assert.assertTrue(actualResult1.endsWith(exptectedResult1));

        }

        @Test
    public void signUpTest() throws InterruptedException {
    //Podaci:
            //name: Ime i prezime polaznika
            //email template: ime.prezime@itbootcamp.rs
            //password: 12346
            //confirm password: 123456
            //assert:
            //Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT:
            //Verify your account

            String expectedResult = "IMPORTANT: Verify your account";
            signUpPage.signUpMethod("Jelena Vuckovic", "jelena.vuckovic@itbootcamp.rs", "12346", "12346");

            Thread.sleep(5000);
            WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div/div[1]"));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Assert.assertEquals(actualResult.getText(), expectedResult);

            WebElement closeWindowBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button/span"));
            closeWindowBtn.click();
        }




}
