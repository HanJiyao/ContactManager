package itp212.contacts;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.Objects;

@ManagedBean
public class Contact {
	private String id;
	private String givenName;
	private String familyName;
	private String contactNum;
	private String email;
	private String address;
	private String postal;
	public Contact(){
		this.reset();
	}

	public Contact(String id, String givenName, String familyName, String contactNum, String email, String address, String postal) {
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.contactNum = contactNum;
		this.email = email;
		this.address = address;
		this.postal = postal;
	}


	public void reset(){
		this.id = "";
		this.givenName = "";
		this.familyName = "";
		this.contactNum = "";
		this.email = "";
		this.address = "";
		this.postal = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	public String getPostal() { return postal; }

	public void setPostal(String postal) { this.postal = postal; }

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Contact other = (Contact) obj;
		if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contact{" +
			"id='" + id + '\'' +
			", givenName='" + givenName + '\'' +
			", familyName='" + familyName + '\'' +
			", contactNum='" + contactNum + '\'' +
			", email='" + email + '\'' +
			", address='" + address + '\'' +
			", postal='" + postal + '\'' +
			'}';
	}
}
