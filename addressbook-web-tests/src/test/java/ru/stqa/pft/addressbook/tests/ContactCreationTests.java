package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToNewContact();
    app.getContactHelper().fillContactForm(new GroupContactData("testname", "testmname", "testlname", "testnik", "C:\\1.png", "testtitle", "testcompany", "testadress", "testhome", "testmobile", "testwork", "testfax", "testmail", "testmail2", "testmail3", "testhompage"));
    app.getContactHelper().supmitContactCreation();
    app.getNavigationHelper().returnToMainPage();
  }
}
