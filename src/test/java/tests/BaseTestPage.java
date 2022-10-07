package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.time.Duration;

import static java.time.Duration.*;

public class BaseTestPage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;


    public BaseTestPage() { }



        @BeforeClass
        public void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jelena\\Desktop\\chrome_driver\\chromedriver.exe");
            driver = new ChromeDriver();
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.manage().timeouts().implicitlyWait(ofSeconds(5));
            homePage = new HomePage(driver, webDriverWait);
            loginPage = new LoginPage(driver, webDriverWait);
            signUpPage = new SignUpPage(driver, webDriverWait);
        }

        @BeforeMethod
        public void beforeMethod() {
            driver.get("https://vue-demo.daniel-avellaneda.com");
        }

        @AfterClass
        public void afterClass() {
            driver.quit();
        }

    }


