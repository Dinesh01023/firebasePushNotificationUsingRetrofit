package pcn.action.sunichith.developer.firebasepushnotification.Retrofit.ModelClass;

public class MessageObject {

    private String  token ;
    private NotificationObj notification;


    public MessageObject(String token, NotificationObj notificationObj) {
        this.token = token;
        this.notification = notificationObj;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public NotificationObj getNotification() {
        return notification;
    }

    public void setNotification(NotificationObj notification) {
        this.notification = notification;
    }
}
