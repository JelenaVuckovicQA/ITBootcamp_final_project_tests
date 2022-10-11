package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTestPage {

    @Test
    public void editsProfile() {

        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        profilePage.getProfileButton().click();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = "Bucaramanga";
        String country = faker.address().country();
        String twitter = faker.internet().avatar();
        String gitHub = faker.internet().avatar();

        profilePage.changeProfileMethod(name, phone, city, country, twitter, gitHub);

        profilePage.getSaveButton().click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"),
                "Profile saved successfuly\nCLOSE"));

        String actualResult = profilePage.getSaveSuccessfullyMessage().getText();
        String expectedResult = "Profile saved successfuly";

        Assert.assertTrue(actualResult.contains(expectedResult));

        String actualName = profilePage.getName().getAttribute("value");
        String actualPhone = profilePage.getPhone().getAttribute("value");
        String actualCity = profilePage.getCity().getAttribute("value");
        String actualCountry = profilePage.getCountry().getAttribute("value");
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        String actualGitHub = profilePage.getGitHub().getAttribute("value");

        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPhone, phone);
        Assert.assertEquals(actualCity, "Bucaramanga");
        Assert.assertEquals(actualCountry, country);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertEquals(actualGitHub, gitHub);

    }
}
