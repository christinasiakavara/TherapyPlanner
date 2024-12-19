package DETsCode.Message;

import java.time.LocalDateTime;

public class Message { 
    private int messageid;
    private int chatid;
    private int senderid;
    private int receiverid;
    private LocalDateTime timestamp;


    public Message(int messageid, int chatid, int senderid, int receiverid, LocalDateTime timestamp) {
        this.messageid = messageid;
        this.chatid = chatid;
        this.senderid = senderid;
        this.receiverid = receiverid;
        this.timestamp = timestamp;
    }

    public int getMessageid() {
        return this.messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public int getChatid() {
        return this.chatid;
    }

    public void setChatid(int chatid) {
        this.chatid = chatid;
    }

    public int getSenderid() {
        return this.senderid;
    }

    public void setSenderid(int senderid) {
        this.senderid = senderid;
    }

    public int getReceiverid() {
        return this.receiverid;
    }

    public void setReceiverid(int receiverid) {
        this.receiverid = receiverid;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{" +
            " messageid='" + getMessageid() + "'" +
            ", chatid='" + getChatid() + "'" +
            ", senderid='" + getSenderid() + "'" +
            ", receiverid='" + getReceiverid() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }
    
}
