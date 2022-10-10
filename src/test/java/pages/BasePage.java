package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

        protected WebDriver driver;
        protected WebDriverWait webDriverWait;


    public BasePage(WebDriver driver, WebDriverWait webDriverWait) {
            this.driver = driver;
            this.webDriverWait = webDriverWait;
        }
        public WebDriver getDriver() {
            return driver;
        }

        public WebDriverWait getWebDriverWait() {
            return webDriverWait;
        }
    }

