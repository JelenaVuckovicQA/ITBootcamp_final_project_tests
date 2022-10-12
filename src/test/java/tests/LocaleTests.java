package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocaleTests extends BaseTestPage {

    @Test


    public void esLanguageTest() {
        localPage.changeLanguageMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        localPage.languageEsMethod();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertEquals(actualResult.getText(), "Página de aterrizaje");

    }

    @Test
    public void engLanguageTest() {
        localPage.changeLanguageMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        localPage.languageEngMethod();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertEquals(actualResult.getText(), "Landing");
    }

    @Test
    public void franceLanguageTest() {
        localPage.changeLanguageMethod();
        webDriverWait.withTimeout(Duration.ofSeconds(5));
        localPage.languageFrMethod();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertEquals(actualResult.getText(), "Page d'atterrissage");

    }
}

