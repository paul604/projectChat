package fr.paul.tChaton.api.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Message {
    private String message = IConstant.DEFAULT_MESSAGE;

    List<Message> history = new ArrayList<>();

    //-----------------------------
    //        Constructeur
    //-----------------------------

    public Message() {

    }

    public Message(String message) {
        this.message = message;
    }

    public Message(Exception exception) {

    }

    //-----------------------------
    //          Get & Set
    //-----------------------------

    public String getMessage() {
        return message;
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
}
