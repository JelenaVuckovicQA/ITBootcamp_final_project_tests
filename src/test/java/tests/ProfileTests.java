package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTestPage {

    @Test
    public void editProfileTest() {
        String expectedResult = "Profile saved successfuly";

        homePage.goToLogin();
        loginPage.loginMethod("admin@admin.com", "12345");
        profilePage.getMyProfileBtn().click();

        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String city = faker.address().city();
        String country = faker.country().name();
        String twitter = "http://" + faker.internet().domainName();
        String github = "http://" + faker.internet().domainName();

        profilePage.editProfileMethod(name, phone, city, country, twitter, github);

        String actualName = profilePage.getName().getAttribute("value");
        String actualPhone = profilePage.getPhone().getAttribute("value");
        String actualCountry = profilePage.getCountry().getAttribute("value");
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        String actualGithub = profilePage.getGitHub().getAttribute("value");

        Assert.assertEquals(name, actualName);
        Assert.assertEquals(phone, actualPhone);
        Assert.assertEquals(country, actualCountry);
        Assert.assertEquals(twitter, actualTwitter);
        Assert.assertEquals(github, actualGithub);

        String actualResult = profilePage.getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));


    }
}