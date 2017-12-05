package fr.paul.tChaton.api.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class History {

    User user;
    List<Message> messages;

    //-----------------------------
    //        Constructeur
    //-----------------------------

    public History(User user) {
        this(user, new ArrayList<>());
    }

    public History(User user, List<Message> messages) {
        this.user = user;
        this.messages = messages;
    }

    public boolean isEmpty(){
        return messages.isEmpty();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof History)) return false;

        History history = (History) o;

        if (user != null ? !user.equals(history.user) : history.user != null) return false;
        return messages != null ? messages.equals(history.messages) : history.messages == null;
    }
}
