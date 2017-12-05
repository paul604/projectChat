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
    private User forUser;
    private Calendar creationDate = Calendar.getInstance();
    private Calendar sendDate= Calendar.getInstance();

    //-----------------------------
    //        Constructeur
    //-----------------------------

    public Message(User user, User forUser) {
        this.from = user;
        this.forUser = forUser;
    }

    public Message(User user, User forUser, String message, Calendar creationDate) {
        this(user, forUser);
        this.message = message;
        this.creationDate = creationDate;
    }

    //-----------------------------
    //          Get & Set
    //-----------------------------


    public User getFrom() {
        return from;
    }

    public User getForUser() {
        return forUser;
    }

    public String getMessage() {
        return message;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public Calendar getSendDate() {
        return sendDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public void setForUser(User forUser) {
        this.forUser = forUser;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public void setSendDate(Calendar sendDate) {
        this.sendDate = sendDate;
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
        if (from != null ? !from.equals(message1.from) : message1.from != null) return false;
        if (forUser != null ? !forUser.equals(message1.forUser) : message1.forUser != null) return false;
        if (creationDate != null ? !creationDate.equals(message1.creationDate) : message1.creationDate != null)
            return false;
        return sendDate != null ? sendDate.equals(message1.sendDate) : message1.sendDate == null;
    }
}
