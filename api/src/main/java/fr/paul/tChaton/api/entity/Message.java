package fr.paul.tChaton.api.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Message {
    private String message = IConstant.DEFAULT_MESSAGE;

    List<Message> history = new ArrayList<>();

    private Calendar creationDate;
    private Calendar sendDate;

    //-----------------------------
    //        Constructeur
    //-----------------------------

    public Message() {

    }

    public Message(String message, Calendar creationDate) {
        this.message = message;
        this.creationDate = creationDate;
        this.sendDate = Calendar.getInstance();
    }

    public Message(Exception exception) {

    }

    //-----------------------------
    //          Get & Set
    //-----------------------------

    public String getMessage() {
        return message;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public Calendar getSendDate() {
        return sendDate;
    }

    public List<Message> getHistory() {
        return history;
    }

    public void setHistory(List<Message> history) {
        this.history = history;
    }

    public boolean isEmpty() {
        return false; //TODO
    }

    //-----------------------------
    //          Overide
    //-----------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message1 = (Message) o;

        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (creationDate != null ? !creationDate.equals(message1.creationDate) : message1.creationDate != null)
            return false;
        return sendDate != null ? sendDate.equals(message1.sendDate) : message1.sendDate == null;
    }
}
