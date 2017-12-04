package fr.paul.tChaton.api.entity;

import java.util.Calendar;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Message {
    private String message = AConstant.DEFAULT_MESSAGE;

    private User from;
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
