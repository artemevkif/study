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
public class DeleteContactFromGroup extends TestBase {

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

    @BeforeMethod
    public void ensureInGroupPreconditions() {
        Contacts contactsList = app.db().contacts();
        for (ContactData contact : contactsList) {
            if (contact.getGroups().size() == 0) {
                app.goTo().MainPage();
                Groups groups = app.db().groups();
                GroupData selectedGroup = groups.iterator().next();
                app.contact().selectGroup(selectedGroup.getId());
                app.contact().addContactInGroup(contact.getId());
            }
        }
    }


    @Test
    public void testContactFromGroupDelete() {
        Contacts contacts = app.db().contacts();
        app.goTo().MainPage();
        ContactData contactFromGroup = contacts.iterator().next();
        Groups movingContactGroups = contactFromGroup.getGroups();
        GroupData group = movingContactGroups.iterator().next();
        app.contact().selectGroupFilter(group.getId());
        app.contact().deleteContactGroup(contactFromGroup.getId());
        Contacts after = app.db().contacts();
        ContactData moveContact = new ContactData();
        for (ContactData contact : after) {
            if (contact.equals(contactFromGroup)) {
                moveContact = contact;
            }
        }
        app.goTo().MainPage();
        Groups movedContactGroups = moveContact.getGroups();
        assertThat(movedContactGroups, equalTo(movingContactGroups.without(group)));
        verifyContactListInUI();
    }
}



