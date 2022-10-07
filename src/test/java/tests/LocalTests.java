package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalTests extends BaseTestPage{

        @Test(priority = 1)
        public void esLanguageTest() throws InterruptedException {
            localPage.changeLanguage();
            localPage.languageEs();
            WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
            Assert.assertEquals(actualResult.getText(), "Página de aterrizaje");

        }

        @Test (priority = 2)
        public void engLanguageTest() throws InterruptedException {
            localPage.changeLanguage();
            localPage.languageEn();
            WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
            Assert.assertEquals(actualResult.getText(), "Landing");
        }

        @Test(priority = 3)
        public void franceLanguageTest() throws InterruptedException {
            localPage.changeLanguage();
            localPage.languageFr();
            WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
            Assert.assertEquals(actualResult.getText(), "Page d'atterrissage");

        }
    }

