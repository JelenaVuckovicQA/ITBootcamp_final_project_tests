package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage extends BasePage {
    private final String newCityName = "New Name";
    protected By adminBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]/span");
    protected By citiesBtn = By.xpath("//*[@id='app']/div[3]/div[1]/a[1]");
    protected By addNewCity = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span/i");
    protected By cityName = By.xpath("//*[@id='name']");
    protected By saveBtn = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    protected By editBtn = By.xpath("//*[@id='edit']/span/i");
    protected By editCityName = By.xpath("//*[@id='name']");
    protected By saveNewCityName = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    protected By searchField = By.xpath("//*[@id='search']");
    protected By searchBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[3]/div/i");
    protected By deleteBtn = By.id("delete");
    protected By deleteCityFinal = By.xpath("//*[@id='app']/div[5]/div/div/div[2]/button[2]");

    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getCities() {
        return getDriver().findElement(citiesBtn);
    }

    public WebElement getAddNewCityOption() {
        return getDriver().findElement(addNewCity);
    }

    public WebElement getCityName() {
        return getDriver().findElement(cityName);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public WebElement getEditBtn() {
        return getDriver().findElement(editBtn);
    }

    public WebElement getEditItem() {
        return getDriver().findElement(editCityName);
    }

    public WebElement getSaveEditItem() {
        return getDriver().findElement(saveNewCityName);
    }

    public WebElement getSearchBox() {
        return getDriver().findElement(searchField);
    }

    public WebElement getSearchBtn() {
        return getDriver().findElement(searchBtn);
    }

    public void clickAdminBtn() {
        getAdminBtn().click();
    }

    public void clickCitiesBtn() {
        getCities().click();
    }

    public String getNewCityName() {
        return newCityName;
    }


    public WebElement getDeleteBtn() {
        return getDriver().findElement(deleteBtn);
    }

    public WebElement getDeleteCityFinal() {
        return getDriver().findElement(deleteCityFinal);
    }

    public void addNewCityMethod(String name) {
        getAddNewCityOption().click();
        getCityName().click();
        getCityName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCityName().sendKeys(name);
        getSaveBtn().click();
    }

    public void editCityMethod() {
        getEditBtn().click();
        getEditItem().click();
        getCityName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getEditItem().sendKeys(newCityName);
        getSaveEditItem().click();
    }

    public void searchCityMethod() {
        getSearchBox().click();
        getSearchBox().sendKeys(newCityName);
        getSearchBtn().click();
    }

    public WebElement getFirstCityText() {
        return getDriver().findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
    }

    public WebElement getSearchedText() {
        return getDriver().findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
    }

    public void deleteCity() {
        getDeleteBtn().click();
    }

    public void deleteCityMethod() {
        getDeleteCityFinal().click();
    }

}
