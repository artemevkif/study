package ru.stqa.pft.mantis.tests;

import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

/**
 * Created by xxartema on 26.02.2017.
 */
public class BugifyTests extends TestBase {

    @BeforeClass
    public void init() {
        RestAssured.authentication = RestAssured.basic(app.getProperty("web.codeAuth"), app.getProperty("web.passAuth"));
    }

    @Test
    public void bugifyTests() throws IOException, ServiceException {
        try {
            skipIfNotFixedBugify(1);
        } catch (SkipException e) {
            e.printStackTrace();
        }
        HttpSession session = app.newSession();
        assertTrue(session.login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword")));
        assertTrue(session.isLoggedInAs(app.getProperty("web.adminLogin")));
    }
}