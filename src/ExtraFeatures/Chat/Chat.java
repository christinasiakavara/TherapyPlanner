package DETsCode.ExtraFeatures.Chat;

import java.util.List;

import DETsCode.ExtraFeatures.*;

public class Chat {

    private int chatid;
    private int participantpatientid;
    private int participanttherapistid;
    private List<Message> messages;

    public Chat(int chatid, int participantpatientid, int participanttherapistid, List<Message> messages) {
        this.chatid = chatid;
        this.participantpatientid = participantpatientid;
        this.participanttherapistid = participanttherapistid;
        this.messages = messages;
    }

    public int getChatid() {
        return this.chatid;
    }

    public void setChatid(int chatid) {
        this.chatid = chatid;
    }

    public int getParticipantpatientid() {
        return this.participantpatientid;
    }

    public void setParticipantpatientid(int participantpatientid) {
        this.participantpatientid = participantpatientid;
    }

    public int getParticipanttherapistid() {
        return this.participanttherapistid;
    }

    public void setParticipanttherapistid(int participanttherapistid) {
        this.participanttherapistid = participanttherapistid;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "{"
                + " chatid='" + getChatid() + "'"
                + ", participantpatientid='" + getParticipantpatientid() + "'"
                + ", participanttherapistid='" + getParticipanttherapistid() + "'"
                + ", messages='" + getMessages() + "'"
                + "}";
    }

}
