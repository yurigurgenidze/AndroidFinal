
package yuri.gurgenidze.ge.finalproject.model.login;


import com.google.gson.annotations.SerializedName;

public class SessionDetails {

    @SerializedName("IsChannelActive")
    private Boolean isChannelActive;
    @SerializedName("SessionTimeout")
    private Integer sessionTimeout;

    public Boolean getIsChannelActive() {
        return isChannelActive;
    }

    public void setIsChannelActive(Boolean isChannelActive) {
        this.isChannelActive = isChannelActive;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

}
