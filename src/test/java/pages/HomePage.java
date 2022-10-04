package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By homeButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]/span");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signUpBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span");

    public HomePage() {

    }

    public HomePage(By homeButton, By loginBtn, By signUpBtn) {
        this.homeButton = homeButton;
        this.loginBtn = loginBtn;
        this.signUpBtn = signUpBtn;
    }

    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public By getHomeButton() {
        return homeButton;
    }

    public By getLoginBtn() {
        return loginBtn;
    }

    public By getSignUpBtn() {
        return signUpBtn;
    }


    public void goToLoginpage() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/login");
    }
}

