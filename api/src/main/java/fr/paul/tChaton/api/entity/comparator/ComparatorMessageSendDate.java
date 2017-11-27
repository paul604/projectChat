package fr.paul.tChaton.api.entity.comparator;

import fr.paul.tChaton.api.entity.Message;

import java.util.Comparator;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class ComparatorMessageSendDate implements Comparator<Message> {

    @Override
    public int compare(Message o1, Message o2) {
        return o1.getSendDate().compareTo(o2.getSendDate());
    }

}
