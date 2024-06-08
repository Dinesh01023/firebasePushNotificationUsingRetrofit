package pcn.action.sunichith.developer.firebasepushnotification.Retrofit.ModelClass;

public class MainObj {

    private MessageObject message;

    public MainObj(MessageObject message) {
        this.message = message;
    }


    public MessageObject getMessage() {
        return message;
    }

    public void setMessage(MessageObject message) {
        this.message = message;
    }
}
