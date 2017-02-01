package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xxartema on 09.01.2017.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void supmitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void deleteSelected() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void fillContactForm(ContactData contactData, boolean createon) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
//    typeforphoto(By.name("photo"), groupContactData.getPhoto());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());

    if (createon) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void alertaccept() {
    wd.switchTo().alert().accept();
  }

  public void supmitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void initContactModification(int id) {
    wd.findElement(By.xpath("//tr[@name = 'entry']/td[8]/a[@href = 'edit.php?id=" + id + "']")).click();
  }

  public void initContactCreation() {
    click(By.xpath("//div[@id='nav']//a[.='add new']"));
  }


  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    supmitContactCreation();
  }

  public void returnToMain() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']/td[3]"));
    for (WebElement element : elements) {
      String name = element.getText();
      String lastname = wd.findElement(By.xpath("//tr[@name = 'entry']/td[2]")).getText();
      int id = Integer.parseInt(wd.findElement(By.cssSelector(".center input")).getAttribute("id"));
      contacts.add(new ContactData().withId(id).withFirstname(name).withLastname(lastname));
    }
    return contacts;
  }

  public void modify(ContactData contact) {
    returnToMain();
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    supmitContactModification();
    returnToMain();
  }

  public void delete(ContactData contact) {
    returnToMain();
    selectContactById(contact.getId());
    deleteSelected();
    alertaccept();
    returnToMain();
  }
}
