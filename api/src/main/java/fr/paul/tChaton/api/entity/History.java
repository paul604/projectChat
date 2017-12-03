package fr.paul.tChaton.api.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class History {

    List<Message> messages;

    //-----------------------------
    //        Constructeur
    //-----------------------------

    public History() {
        messages = new ArrayList<>();
    }

    public History(List<Message> messages) {
        this.messages = messages;
    }

    //-----------------------------
    //          get & set
    //-----------------------------

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
