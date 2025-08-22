import java.io.Serializable;
import java.time.LocalDate;

public class Notifications implements Serializable {
    private long Id;
    private long customerId;
    private String notification;
    private int isRead;

    public Notifications(long Id,String notification, int isRead) {
        this.Id = Id;
        this.notification = notification;
        this.isRead = isRead;
    }

    public long getId() {
        return Id;
    }


    public long getCustomerId() {
        return customerId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}