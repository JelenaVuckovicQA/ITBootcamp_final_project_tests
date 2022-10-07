package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    protected By home =  By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[1]/span");
    protected By about =  By.xpath("//*[@id='app]/div/div/header/div/div[3]/a[2]/span");
    protected By login =  By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[3]/span");
    protected By signUp =  By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[4]/span");

    private By adminBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getHome() {
        return getDriver().findElement(home);
    }

    public WebElement getAbout() {
        return getDriver().findElement(about);
    }

    public WebElement getLogin() {
        return getDriver().findElement(login);
    }

    public WebElement getSignUp() {
        return getDriver().findElement(signUp);
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }


    public void goToLogin(){
        getLogin().click();
    }
    public void goToSignUp(){
        getSignUp().click();
    }
}



