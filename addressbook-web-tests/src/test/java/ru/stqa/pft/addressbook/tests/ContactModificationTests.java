package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContactData;

/**
 * Created by xxartema on 09.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new GroupContactData("testname", "testmname", "testlname", "testnik", "C:\\1.png", "testtitle", "testcompany", "testadress", "testhome", "testmobile", "testwork", "testfax", "testmail", "testmail2", "testmail3", "testhompage"));
    app.getContactHelper().supmitContactModification();
    app.getNavigationHelper().returnToMainPage();
  }
}
