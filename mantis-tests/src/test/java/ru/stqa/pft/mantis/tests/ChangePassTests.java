package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;

/**
 * Created by xxartema on 26.02.2017.
 */
public class ChangePassTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testUserPasswordChange() {
        UserData user = new UserData().withUsername("user").withEmail("user@localhost");
        app.navigate().uiLogin();
        app.navigate().manageUsers();
        app.navigate().selectUser(user);
        app.navigate().resetPassowrd();
        System.out.println();
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }

}