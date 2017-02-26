package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.pft.mantis.model.UserData;

/**
 * Created by xxartema on 26.02.2017.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void uiLogin() {
        wd.get(app.getProperty("web.baseUrl") + "login_page.php");
        type(By.xpath("//input[@name='username']"), app.getProperty("web.adminLogin"));
        type(By.xpath("//input[@type='password']"), app.getProperty("web.adminPassword"));
        wd.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void manageUsers() {
        wd.findElement(By.xpath("//a[@href='/mantisbt-1.2.19/manage_overview_page.php']")).click();
        wd.findElement(By.xpath("//a[@href='/mantisbt-1.2.19/manage_user_page.php']")).click();
    }

    public void selectUser(UserData user) {
        String locator = String.format("//a[contains(@href, 'user_id=%s')]", user.getId());
        click(By.xpath(locator));
    }

    public void resetPassowrd() {
        click(By.cssSelector("input[value='Reset Password']"));
        wait.until(ExpectedConditions.urlContains("manage_user_page.php"));
    }
}