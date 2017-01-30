package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xxartema on 09.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testname", "test1", "testmname", "testname", null, "C:\\1.png", "testtitle", "testcompany", "testadress", "testhome", "testmobile", "testwork", "testfax", "testmail", "testmail2", "testmail3", "testhompage"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().returnToMainPage();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = (new ContactData(before.get(before.size() - 1).getId(),"testname", null, null, "testname", "testnik", "C:\\1.png", "testtitle", "testcompany", "testadress", "testhome", "testmobile", "testwork", "testfax", "testmail", "testmail2", "testmail3", "testhompage"));
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().supmitContactModification();
    app.getNavigationHelper().returnToMainPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
