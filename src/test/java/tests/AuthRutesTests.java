package tests;

import org.openqa.selenium.devtools.v85.dom.model.BackendNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRutesTests extends BaseTestPage {

        //Test #1: Forbids visits to home url if not authenticated
        //assert:
        //    • Ucitati /home stranu kada korisnik nije ulogovan
        //    • Verifikovati da se u url-u stranice javlja ruta /login
        @Test
        public void forbidsVisitsTest (){
            String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";

            homePage.goToLogin();

            String actualResult1 = driver.getCurrentUrl();
            Assert.assertEquals(actualResult1, expectedResult1);
        }


        //    • Ucitati /profile stranu
        //    • Verifikovati da se u url-u stranice javlja ruta /login
        @Test
        public void profilePageLoadingTest () {
            driver.get("https://vue-demo.daniel-avellaneda.com/profile");
            String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
            String actualResult2 = driver.getCurrentUrl();
            Assert.assertEquals(actualResult2, expectedResult2);
        }


        //    • Ucitati /admin/cities stranu
        //    • Verifikovati da se u url-u stranice javlja ruta /login
        @Test
        public void adminPageLoadingTest () {
            driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
            String expectedResult3 = "https://vue-demo.daniel-avellaneda.com/login";
            String actualResult3 = driver.getCurrentUrl();
            Assert.assertEquals(actualResult3, expectedResult3);
        }

        //Test #4: Forbids visits to admin users url if not authenticated
        //assert:
        //    • Ucitati /admin/users stranu
        //    • Verifikovati da se u url-u stranice javlja ruta /login
        @Test
        public void forbidNotAuthenticatedUserTest () {
            driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
            String expectedResult4 = "https://vue-demo.daniel-avellaneda.com/login";
            String actualResult4 = driver.getCurrentUrl();
            Assert.assertEquals(actualResult4, expectedResult4);
        }
    }


