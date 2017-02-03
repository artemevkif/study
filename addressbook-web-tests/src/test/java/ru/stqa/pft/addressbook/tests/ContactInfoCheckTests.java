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
public class ContactInfoCheckTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withHome("23123")
              .withMobile("23123")
              .withWork("23123")
              .withAddress("testadress")
              .withFirstname("testname")
              .withLastname("testname")
              .withEmail("testmail")
              .withEmail2("testmail")
              .withEmail3("testmail"));
    }
    app.goTo().contactPage();
  }


  @Test
  public void testContactInfoCheck() {
    app.goTo().MainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromInfoForm = app.contact().infoFromInfoForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat((mergeAll(contactInfoFromEditForm)),
            equalTo(contactInfoFromInfoForm.getAllInfo()));
  }


  private String mergeAll(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), " ", contact.getLastname(), "\n", contact.getAddress(),
            "\n", "\n", "H: ", contact.getHome(), "\n", "M: ", contact.getMobile(), "\n", "W: ", contact.getWork(), "\n", "\n", contact.getEmail(), "\n",
            contact.getEmail2(), "\n", contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactInfoCheckTests::cleaned)
            .collect(Collectors.joining());
  }

  public static String cleaned(String info) {
    return info.replaceAll("[-()]", "");
  }
}
