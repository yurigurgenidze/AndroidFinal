
package yuri.gurgenidze.ge.finalproject.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientMail {

    @SerializedName("Contact")
    @Expose
    private String contact;
    @SerializedName("Route")
    @Expose
    private String route;
    @SerializedName("DefaultContact")
    @Expose
    private String defaultContact;
    @SerializedName("ContactName")
    @Expose
    private String contactName;
    @SerializedName("Mail")
    @Expose
    private String mail;
    @SerializedName("Mobile")
    @Expose
    private Mobile mobile;
    @SerializedName("Device")
    @Expose
    private Device device;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDefaultContact() {
        return defaultContact;
    }

    public void setDefaultContact(String defaultContact) {
        this.defaultContact = defaultContact;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
