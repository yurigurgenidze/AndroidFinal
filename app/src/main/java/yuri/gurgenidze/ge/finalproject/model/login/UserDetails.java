
package yuri.gurgenidze.ge.finalproject.model.login;


import com.google.gson.annotations.SerializedName;

public class UserDetails {

    @SerializedName("UserId")
    private Integer userId;
    @SerializedName("Username")
    private String username;
    @SerializedName("Name")
    private String name;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("PhoneForSms")
    private String phoneForSms;
    @SerializedName("Active")
    private Boolean active;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneForSms() {
        return phoneForSms;
    }

    public void setPhoneForSms(String phoneForSms) {
        this.phoneForSms = phoneForSms;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
