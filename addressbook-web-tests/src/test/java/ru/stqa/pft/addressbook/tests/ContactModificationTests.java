package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by xxartema on 09.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("testname", null,null, null, "testnik", "C:\\1.png", "testtitle", "testcompany", "testadress", "testhome", "testmobile", "testwork", "testfax", "testmail", "testmail2", "testmail3", "testhompage"), false);
    app.getContactHelper().supmitContactModification();
    app.getNavigationHelper().returnToMainPage();
  }
}
