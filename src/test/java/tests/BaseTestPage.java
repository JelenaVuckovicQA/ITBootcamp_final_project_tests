package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTestPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage ;
    protected LoginPage loginPage;



    public BaseTestPage() {

    }


    @BeforeClass
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jelena\\Desktop\\chrome_driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://vue-demo.daniel-avellaneda.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            homePage = new HomePage(driver, wait);
            loginPage = new LoginPage(driver, wait);

        }

        @BeforeMethod
        public void beforeMethod() {
            driver.get("https://vue-demo.daniel-avellaneda.com/");
        }

        @AfterClass
        public void closeDriver() {
            driver.quit();
        }


}



