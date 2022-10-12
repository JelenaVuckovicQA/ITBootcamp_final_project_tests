package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends BasePage {
    private final By myProfileBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private final By name = By.id("name");
    private final By phone = By.id("phone");
    private final By city = By.id("city");
    private final By country = By.id("country");
    private final By twitter = By.name("urlTwitter");
    private final By github = By.name("urlGitHub");
    private final By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private final By saveMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");

    public ProfilePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getMyProfileBtn() {
        return getDriver().findElement(myProfileBtn);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitter() {
        return getDriver().findElement(twitter);
    }

    public WebElement getGitHub() {
        return getDriver().findElement(github);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public void editProfileMethod(String name, String phone, String city, String country, String twitter, String github) {

        getMyProfileBtn().click();

        getName().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getName().sendKeys(name);

        getPhone().click();
        getPhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhone().sendKeys(phone);

        getCity().click();
        getCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCity().sendKeys(city);

        getCountry().click();
        getCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountry().sendKeys(country);

        getTwitter().click();
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitter().sendKeys(twitter);

        getGitHub().click();
        getGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHub().sendKeys(github);

        getSaveBtn().click();

    }

}
