package fr.paul.tChaton.api.entity;

import fr.paul.tChaton.api.entity.comparator.ComparatorMessageSendDate;
import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class MessageTest {

    @Test
    public void createEmptyMessage() throws Exception {
        assertEquals("empty Message", AConstant.DEFAULT_MESSAGE, new Message(null, null).getMessage());
    }

    @Test
    public void sendDate() throws Exception {
        assertEquals("test sendDate",
                Calendar.getInstance().getTime().toString(),
                new Message(null, null, "msg test", null).getSendDate().getTime().toString());
    }

    @Test
    public void compareSendDateAscending() throws Exception {
        Message message1 = new Message(null, null, "1", null);
        Thread.sleep(10);//for different time
        Message message2 = new Message(null, null, "2", null);

        List<Message> messagesOrderOk = new LinkedList<>();
        messagesOrderOk.add(message1);
        messagesOrderOk.add(message2);

        List<Message> messages = new LinkedList<>();
        messages.add(message2);
        messages.add(message1);

        messages.sort(new ComparatorMessageSendDate());

        assertArrayEquals("comparer ceation Date ascending", messagesOrderOk.toArray(new Message[0]), messages.toArray(new Message[0]));

    }

    @Test
    public void compareSendDateDescending() throws Exception {
        Message message1 = new Message(null, null, "1", null);
        Thread.sleep(10);//for different time
        Message message2 = new Message(null, null, "2", null);

        List<Message> messagesOrderOk = new LinkedList<>();
        messagesOrderOk.add(message2);
        messagesOrderOk.add(message1);

        List<Message> messages = new LinkedList<>();
        messages.add(message1);
        messages.add(message2);

        messages.sort(new ComparatorMessageSendDate().reversed());

        assertArrayEquals("comparer ceation Date ascending", messagesOrderOk.toArray(new Message[0]), messages.toArray(new Message[0]));

    }
}