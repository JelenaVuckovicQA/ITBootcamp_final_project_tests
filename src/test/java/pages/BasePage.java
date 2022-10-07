package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

        protected WebDriver driver;
        protected WebDriverWait webDriverWait;

    public BasePage(WebDriverWait driverWait) {
        this.webDriverWait = webDriverWait;
    }

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
            this.driver = driver;
            this.webDriverWait = webDriverWait;
        }
        public WebDriver getDriver() {
            return driver;
        }

        public WebDriverWait getDriverWait() {
            return webDriverWait;
        }
    }

