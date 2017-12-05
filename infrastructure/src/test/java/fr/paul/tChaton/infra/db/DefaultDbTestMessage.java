package fr.paul.tChaton.infra.db;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class DefaultDbTestMessage {

    @Test
    public void addOneMessage() throws Exception {
        DefaultDb db = new DefaultDb();
        Message message = new Message(AConstant.DEFAULT_USER, AConstant.SERVER_USER, AConstant.DEFAULT_MESSAGE, null);
        db.addMessage(message);

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        assertArrayEquals("addOneMessage", messages.toArray(new Message[0]), db.getMessageList().toArray(new Message[0]));
    }

    @Test
    public void delMessage() throws Exception {

        DefaultDb db = new DefaultDb();
        Message message = new Message(AConstant.DEFAULT_USER, AConstant.SERVER_USER, AConstant.DEFAULT_MESSAGE, null);
        db.addMessage(message);

        db.delMessage(message);

        assertTrue(db.getMessageList().isEmpty());
    }

    @Test
    public void testGetHistoryForDefaultUser() throws Exception {
        DefaultDb db = new DefaultDb();
        Message message1 = new Message(AConstant.DEFAULT_USER, AConstant.SERVER_USER, AConstant.DEFAULT_MESSAGE, Calendar.getInstance());
        Thread.sleep(10);
        Message message2 = new Message(AConstant.SERVER_USER, AConstant.DEFAULT_USER, AConstant.DEFAULT_MESSAGE, Calendar.getInstance());
        db.addMessage(message1);
        db.addMessage(message2);

        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        assertArrayEquals("testGetHistoryForDefaultUser", messages.toArray(new Message[0]), db.getHistoryOf(AConstant.DEFAULT_USER_ID).toArray(new Message[0]));
    }
}