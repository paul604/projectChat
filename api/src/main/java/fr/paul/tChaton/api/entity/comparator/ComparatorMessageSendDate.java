package fr.paul.tChaton.api.entity.comparator;

import fr.paul.tChaton.api.entity.Message;

import java.util.Comparator;

/**
 * Created by Paul on 27/11/17.
 */
public class ComparatorMessageSendDate implements Comparator<Message> {

    @Override
    public int compare(Message o1, Message o2) {
        return o1.getSendDate().compareTo(o2.getSendDate());
    }

}
