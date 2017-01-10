package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by xxartema on 09.01.2017.
 */

public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("pass"), password);
    type(By.name("user"), username);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
