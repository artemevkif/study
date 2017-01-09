package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xxartema on 09.01.2017.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void returnToMainPage() {
    click(By.linkText("home"));
  }

  public void goToNewContact() {
    click(By.linkText("add new"));
  }
}
