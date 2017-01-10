package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupContactData;

/**
 * Created by xxartema on 09.01.2017.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void supmitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() {
    click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void fillContactForm(GroupContactData groupContactData) {
    type(By.name("firstname"), groupContactData.getFirstname());
    type(By.name("middlename"), groupContactData.getMiddlename());
    type(By.name("lastname"), groupContactData.getLastname());
    type(By.name("nickname"), groupContactData.getNickname());
//    typeforphoto(By.name("photo"), groupContactData.getPhoto());
    type(By.name("title"), groupContactData.getTitle());
    type(By.name("company"), groupContactData.getCompany());
    type(By.name("address"), groupContactData.getAddress());
    type(By.name("home"), groupContactData.getHome());
    type(By.name("mobile"), groupContactData.getMobile());
    type(By.name("work"), groupContactData.getWork());
    type(By.name("fax"), groupContactData.getFax());
    type(By.name("email"), groupContactData.getEmail());
    type(By.name("email2"), groupContactData.getEmail2());
    type(By.name("email3"), groupContactData.getEmail3());
    type(By.name("homepage"), groupContactData.getHomepage());
  }

  public void alertaccept() {
    wd.switchTo().alert().accept();
  }

  public void supmitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img"));

  }
}
