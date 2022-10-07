package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCityTests extends BaseTestPage {

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void createCityTest() throws InterruptedException {
        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        adminPage.clickCitiesBtn();
        adminPage.createCityMethod();
        Thread.sleep(3000);
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
        loginPage.getLogoutBtn().click();
    }

  /*  @Test(priority = 3)
    public void editCityTest() throws InterruptedException {
        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        adminPage.clickCitiesBtn();
        adminPage.editCityMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(10));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));

    }

    @Test (priority = 4)
    public void searchCityTest() throws InterruptedException {

        //Podaci: editovani grad iz testa #3
        //assert:
        //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        adminPage.clickAdminBtn();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        adminPage.clickCitiesBtn();
        adminPage.editCityMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(10));
        adminPage.searchCityMethod();
        WebElement townSelected = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        String actualResult = townSelected.getText();
        Assert.assertEquals(actualResult, "New Town Name");

    }*/
}