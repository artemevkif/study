package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData()
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
            .withGroup("test1")
            .withPhoto(photo);
    app.contact().create(contact);
    app.goTo().MainPage();
    assertThat(app.contact().count(), equalTo(before.size()+ 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}




