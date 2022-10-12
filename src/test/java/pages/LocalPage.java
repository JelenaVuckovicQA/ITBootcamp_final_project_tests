package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalPage extends BasePage {
    protected By language = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button");
    protected By esLanguage = By.xpath("//*[@id='list-item-75']");
    protected By engLanguage = By.xpath("//*[@id='list-item-73']");
    protected By frLanguage = By.xpath("//*[@id='list-item-77']");


    public LocalPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLanguage() {
        return getDriver().findElement(language);
    }

    public WebElement getEsLanguage() {
        return getDriver().findElement(esLanguage);
    }

    public WebElement getEngLanguage() {
        return getDriver().findElement(engLanguage);
    }

    public WebElement getFrLanguage() {
        return getDriver().findElement(frLanguage);
    }

    public void changeLanguageMethod() {
        getLanguage().click();
    }

    public void languageEsMethod() {
        getEsLanguage().click();
    }

    public void languageEngMethod() {
        getEngLanguage().click();
    }

    public void languageFrMethod() {
        getFrLanguage().click();
    }


}
