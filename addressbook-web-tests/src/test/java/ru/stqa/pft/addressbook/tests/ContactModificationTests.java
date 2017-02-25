package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xxartema on 09.01.2017.
 */
public class ContactModificationTests extends TestBase {

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
                    .withFax("testfax"));
        }
    }

    @Test
    public void testContactModification() {
        app.goTo().contactPage();
        Contacts before = app.db().contacts();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = (new ContactData().withId(modifyContact.getId())
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
                .withFax("testfax"));
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
        verifyContactListInUI();
    }
}
