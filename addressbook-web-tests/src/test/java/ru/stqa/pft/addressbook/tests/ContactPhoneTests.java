package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xxartema on 02.02.2017.
 */
public class ContactPhoneTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
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
    app.goTo().contactPage();
  }


  @Test
  public void testContactPhones() {
    app.goTo().MainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
