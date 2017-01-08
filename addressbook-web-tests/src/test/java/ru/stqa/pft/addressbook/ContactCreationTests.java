package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class ContactCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void ContactCreationTests() {
        wd.get("http://localhost:8443/addressbook/");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
        wd.findElement(By.linkText("add new")).click();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys("testname");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).sendKeys("testmname");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).sendKeys("testlname");
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).sendKeys("testnik");
        wd.findElement(By.name("photo")).sendKeys("C:\\1.png");
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).sendKeys("testtitle");
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).sendKeys("testcompany");
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).sendKeys("testadress");
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).sendKeys("testhome");
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).sendKeys("testmobile");
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).sendKeys("testwork");
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).sendKeys("testfax");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys("testmail");
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).sendKeys("testmail2");
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).sendKeys("testmail3");
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).sendKeys("testhompage");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        wd.findElement(By.linkText("home")).click();
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img")).click();
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
