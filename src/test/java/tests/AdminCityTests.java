package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCityTests extends BaseTestPage {

    @Test
    public void adminCitiesUrlTest() throws InterruptedException {
        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        Thread.sleep(5000);
        adminPage.clickCitiesBtn();
        Thread.sleep(5000);
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/admin/cities"));
        String expectedResult = "LOGOUT";
        WebElement actualRes = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertEquals(actualRes.getText(), expectedResult);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage.getLogoutBtn().click();
    }

    @Test
    public void createCityTest() throws InterruptedException {
        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        adminPage.clickCitiesBtn();
        adminPage.addNewCityMethod(adminPage.getNewCityName());
        Thread.sleep(5000);
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
        loginPage.getLogoutBtn().click();
    }

     @Test
    public void editCityTest() throws InterruptedException {
         homePage.goToLogin();
         loginPage.loginMethod("admin@admin.com", "12345");
         adminPage.clickAdminBtn();
         adminPage.clickCitiesBtn();
         adminPage.editCityMethod();
         webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
         WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
         Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
         loginPage.getLogoutBtn().click();
    }

    @Test
    public void searchCityTest() throws InterruptedException {

        //Podaci: editovani grad iz testa #3
        //assert:
        //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        adminPage.clickCitiesBtn();
        adminPage.searchCityMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        Assert.assertEquals(adminPage.getFirstCityText().getText(), adminPage.getSearchedText().getText());
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]"));
        Assert.assertTrue(actualResult.getText().contains(adminPage.getNewCityName()));
        loginPage.getLogoutBtn().click();

    }

    @Test
    public void deleteCityTest() {
        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        adminPage.clickCitiesBtn();

        webDriverWait.withTimeout(Duration.ofSeconds(15));
        adminPage.searchCityMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(5));

        WebElement cityNoOne = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]"));
        webDriverWait.until(ExpectedConditions.visibilityOf(cityNoOne));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(actualResult.getText().contains(adminPage.getNewCityName()));
        adminPage.deleteCity();
        webDriverWait.withTimeout(Duration.ofSeconds(5));

        adminPage.deleteCityMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(5));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        WebElement notificationTextBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(notificationTextBox.getText().contains("Deleted successfully"));
        loginPage.getLogoutBtn().click();
    }
}