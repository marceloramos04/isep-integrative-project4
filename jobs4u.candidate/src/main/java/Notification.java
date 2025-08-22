import java.io.Serializable;

public class Notification implements Serializable {
    private long id;
    private long candidateId;
    private String notification;
    private int isRead;

    public Notification(long id, long candidateId, String notification, int isRead) {
        this.id = id;
        this.candidateId = candidateId;
        this.notification = notification;
        this.isRead = isRead;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
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

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", notification='" + notification + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
