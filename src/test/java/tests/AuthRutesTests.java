package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRutesTests extends BaseTestPage {


    @Test
    ////Forbids visits to home url if not authenticated
    //assert:
    //Load "/home" page if user is not logged in
    //Verify that url contains "login" route
    public void forbidsVisitsTest() {
        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";

        homePage.goToLogin();

        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1, expectedResult1);
    }


    @Test
    //Load "/profile" page
    //Verify that url contains "/login" route
    public void profilePageLoadingTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }


    @Test
    public void adminPageLoadingTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult3 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult3 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult3, expectedResult3);
    }

    @Test
    //Forbids visits to admin users url if not authenticated
    public void forbidNotAuthenticatedUserTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult4 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult4 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult4, expectedResult4);
    }
}


