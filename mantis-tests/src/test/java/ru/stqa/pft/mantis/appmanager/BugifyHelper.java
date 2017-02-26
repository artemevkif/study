package ru.stqa.pft.mantis.appmanager;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import java.io.IOException;

/**
 * Created by xxartema on 26.02.2017.
 */

public class BugifyHelper {

    private ApplicationManager app;

    public BugifyHelper(ApplicationManager app) {
        this.app = app;
    }

    public String getIssueStatusByID(int issueId) throws IOException {
        String json = RestAssured.get(app.getProperty("web.bugifyUrl") + issueId + ".json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        JsonObject issue = issues.getAsJsonArray().get(0).getAsJsonObject();
        return issue.get("state_name").getAsString();
    }
}