package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost:8443/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void testContactCreation() {
    goToNewContact();
    fillContactForm(new GroupContactData("testname", "testmname", "testlname", "testnik", "C:\\1.png", "testtitle", "testcompany", "testadress", "testhome", "testmobile", "testwork", "testfax", "testmail", "testmail2", "testmail3", "testhompage"));
    supmitContactCreation();
    returnToMainPage();
  }

  private void returnToMainPage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void supmitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(GroupContactData groupContactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys(groupContactData.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).sendKeys(groupContactData.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys(groupContactData.getLastname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).sendKeys(groupContactData.getNickname());
    wd.findElement(By.name("photo")).sendKeys(groupContactData.getPhoto());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).sendKeys(groupContactData.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).sendKeys(groupContactData.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).sendKeys(groupContactData.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).sendKeys(groupContactData.getHome());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).sendKeys(groupContactData.getMobile());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).sendKeys(groupContactData.getWork());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).sendKeys(groupContactData.getFax());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).sendKeys(groupContactData.getEmail());
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).sendKeys(groupContactData.getEmail2());
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).sendKeys(groupContactData.getEmail3());
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).sendKeys(groupContactData.getHomepage());
  }

  private void goToNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
