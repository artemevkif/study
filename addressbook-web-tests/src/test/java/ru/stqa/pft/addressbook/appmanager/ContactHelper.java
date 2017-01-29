package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void deleteSelectedContact() {
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

  public void initContactModification(Integer num) {
    wd.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(num).click();
  }

  public void initContactCreation() {
    click(By.xpath("//div[@id='nav']//a[.='add new']"));
  }


  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    supmitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']/td[3]"));
    for (WebElement element : elements) {
      String name = element.getText();
      String lastname = wd.findElement(By.xpath("//tr[@name = 'entry']/td[2]")).getText();
      int id = Integer.parseInt(wd.findElement(By.cssSelector(".center input")).getAttribute("id"));
      ContactData contact = new ContactData(id, name, null, null, lastname, null, null, null,null, null, null,null, null, null,null, null, null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
