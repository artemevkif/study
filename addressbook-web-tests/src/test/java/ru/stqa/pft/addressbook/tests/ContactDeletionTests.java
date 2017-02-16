package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData()
              .withHome("23123")
              .withMobile("23123")
              .withWork("23123")
              .withAddress("testadress")
              .withCompany("testcompany")
              .withFirstname("testname")
              .withLastname("testname")
              .withEmail("testmail")
              .withEmail2("testmail")
              .withEmail3("testmail")
              .withFax("testfax")
              .withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
    ContactData deleteContact = before.iterator().next();
    app.contact().delete(deleteContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deleteContact)));
  }
}
