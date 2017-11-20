package fr.paul.tChaton.Api.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Message {
    private static final String DEFAULT_MESSAGE = IConstant.DEFAULT_MESSAGE;

    List<Message> history = new ArrayList<>();

    public Message() {

    }
    private String message = DEFAULT_MESSAGE;

    public Message(String message) {
        this.message = message;
    }

    public Message(Exception exception) {

    }

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
