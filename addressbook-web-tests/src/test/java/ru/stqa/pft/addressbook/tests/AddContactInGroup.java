package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xxartema on 26.02.2017.
 */
public class AddContactInGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().initGroupCreation();
            app.group().fillGroupForm(new GroupData().withName("test1").withFooter("tes2").withHeader("te3"));
            app.group().supmitGroupCreation();
        }

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
    public void testContactCreation() {
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        app.goTo().MainPage();
        GroupData group = groups.iterator().next();
        ContactData contactToGroup = contacts.iterator().next();
        Groups contactGroups = contactToGroup.getGroups();
        app.contact().selectGroup(group.getId());
        app.contact().addContactInGroup(contactToGroup.getId());
        app.goTo().MainPage();
        assertThat(app.contact().count(), equalTo(contacts.size()));
        Contacts after = app.db().contacts();
        ContactData moveContact = new ContactData();
        for (ContactData contact : after) {
            if (contact.equals(contactToGroup)) {
                moveContact = contact;
            }
        }
        Groups moveContactGroups = moveContact.getGroups();
        assertThat(moveContactGroups, equalTo(contactGroups.withAdded(group)));
        verifyContactListInUI();
    }
}