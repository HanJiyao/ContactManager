package itp212.contacts;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.ejb.SessionContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ManagedBean
@SessionScoped
public class ContactController implements Serializable {

    private List<Contact> contactList;
    private List<Contact> filteredContacts;
    private Contact selectedContact;
    private boolean rowSelected = false;

    public ContactController(){
        this.selectedContact = null;
    }


    public List<Contact> getFilteredContacts() {
        return filteredContacts;
    }

    public void setFilteredContacts(List<Contact> filteredContacts) {
        this.filteredContacts = filteredContacts;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }


    public Contact getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
        System.out.println("============ setSelectedContact " + this.selectedContact);
    }


    public void onRowSelect(SelectEvent event){
        clearContact();
        this.rowSelected = true;
        this.selectedContact = ((Contact) event.getObject());
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = ec.getSessionMap();
        sessionMap.put("contact", this.selectedContact);
    }

    public void saveContact(Contact contact){
        System.out.print(this.selectedContact);
        System.out.print(contact);
        contact.setId(getRandomId());
        if (selectedContact!=null){
            this.selectedContact=contact;
            this.displayConfirmation("Contact Updated for "+selectedContact.getFamilyName()+" "+selectedContact.getGivenName());
        } else {
            contactList.add(contact);
            this.displayConfirmation("New Contact Added for "+contact.getFamilyName()+" "+contact.getGivenName());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contact", new Contact());
            RequestContext.getCurrentInstance().reset("contactDetailForm");
        }
        clearContact();
    }


    private void displayConfirmation(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("appMessage", new FacesMessage("Success",  message) );
    }

    public void deleteContact(){
        System.out.print(selectedContact);
        contactList.remove(selectedContact);
        this.displayConfirmation("Contact Deleted");
        clearContact();
    }

    public void clearContact(){
        this.rowSelected = false;
        this.selectedContact = null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contact", new Contact());
        RequestContext.getCurrentInstance().reset("contactDetailForm");
    }

    public void loadContacts(){
        if (this.contactList == null){
            this.contactList = new ArrayList<Contact>();
            contactList.add(new Contact(this.getRandomId(), "Jacelyn", "Lian", "91234567","Jacelyn@gmail.com","180 Ang Mo Kio Avenue 1 Singapore","698301"));
            contactList.add(new Contact(this.getRandomId(), "Sandra", "Tan",  "92234567","Sandra@gmail.com","180 Ang Mo Kio Avenue 2 Singapore","698302"));
            contactList.add(new Contact(this.getRandomId(), "Sean", "Teo","69934834","Sean@gmail.com","180 Ang Mo Kio Avenue 3 Singapore","698303"));
            contactList.add(new Contact(this.getRandomId(), "Han Boon", "Goh",  "78182374","HanBoon@gmail.com","180 Ang Mo Kio Avenue 4 Singapore","698304"));
            contactList.add(new Contact(this.getRandomId(), "Cheng Ying", "Guo", "63984923","ChengYing@gmail.com","180 Ang Mo Kio Avenue 5 Singapore","698305"));
            contactList.add(new Contact(this.getRandomId(), "Kuan Wei", "Ng", "91757384","KuanWei@gmail.com","180 Ang Mo Kio Avenue 6 Singapore","698306"));
            contactList.add(new Contact(this.getRandomId(), "Kyle", "Solis", "85736498","Kyle@gmail.com","180 Ang Mo Kio Avenue 7 Singapore","698307"));
            contactList.add(new Contact(this.getRandomId(), "Jin Cheng", "Choo", "923487342","JinCheng@gmail.com","180 Ang Mo Kio Avenue 8 Singapore","698308"));
            contactList.add(new Contact(this.getRandomId(), "Jing", "Li",  "99989891","Jing@gmail.com","180 Ang Mo Kio Avenue 9 Singapore","698309"));
            contactList.add(new Contact(this.getRandomId(), "Jeffrey", "Ng", "69817383","Jeffrey@gmail.com","180 Ang Mo Kio Avenue 10 Singapore","983010"));
            contactList.add(new Contact(this.getRandomId(), "Zhi Jie", "Ng", "812549572","ZhiJie@gmail.com","180 Ang Mo Kio Avenue 11 Singapore","983011"));
            contactList.add(new Contact(this.getRandomId(), "Vienna", "Chong", "666598932","Vienna@gmail.com","180 Ang Mo Kio Avenue 12 Singapore","983012"));
            contactList.add(new Contact(this.getRandomId(), "Ivan", "Lai", "815047342","Ivan@gmail.com","180 Ang Mo Kio Avenue 13 Singapore","983013"));
            contactList.add(new Contact(this.getRandomId(), "Chong-Yu", "Leong", "95732958","Chong-Yu@gmail.com","180 Ang Mo Kio Avenue 14 Singapore","983014"));
            contactList.add(new Contact(this.getRandomId(), "Yee Ann", "Tan", "91234567","YeeAnn@gmail.com","180 Ang Mo Kio Avenue 15 Singapore","983015"));
            contactList.add(new Contact(this.getRandomId(), "Zheng Hui", "Toh", "61604743","ZhengHui@gmail.com","180 Ang Mo Kio Avenue 16 Singapore","983016"));
            contactList.add(new Contact(this.getRandomId(), "Syafiq", "Akhbar", "87345918","Syafiq@gmail.com","180 Ang Mo Kio Avenue 17 Singapore","983017"));
            contactList.add(new Contact(this.getRandomId(), "Zheng Xuan", "Chia", "78929743","ZhengXuan@gmail.com","180 Ang Mo Kio Avenue 18 Singapore","983018"));
            contactList.add(new Contact(this.getRandomId(), "Kyi", "Myat", "91234567","Kyi@gmail.com","180 Ang Mo Kio Avenue 19 Singapore","983019"));
            contactList.add(new Contact(this.getRandomId(), "Wen Qiang", "Teo", "601923934","WenQiang@gmail.com","180 Ang Mo Kio Avenue 20 Singapore","983020"));
            contactList.add(new Contact(this.getRandomId(), "Arno", "Gan", "108523934","Arno@gmail.com","180 Ang Mo Kio Avenue 21 Singapore","983021"));
            contactList.add(new Contact(this.getRandomId(), "Jing Le", "Chuang", "7274938","JingLe@gmail.com","180 Ang Mo Kio Avenue 22 Singapore","983022"));
            contactList.add(new Contact(this.getRandomId(), "Lik Wee", "Low", "89387474","LikWee@gmail.com","180 Ang Mo Kio Avenue 23 Singapore","983023"));
            contactList.add(new Contact(this.getRandomId(), "Quang", "Pham","1231231","Quang@gmail.com","180 Ang Mo Kio Avenue 24 Singapore","983024"));
            contactList.add(new Contact(this.getRandomId(), "Xing Yu", "Lim", "32879823","XingYu@gmail.com","180 Ang Mo Kio Avenue 25 Singapore","983025"));
        }
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
