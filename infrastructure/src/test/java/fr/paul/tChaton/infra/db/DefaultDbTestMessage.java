package fr.paul.tChaton.infra.db;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import org.junit.Test;

import java.util.ArrayList;
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
        Message message = new Message(new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME), AConstant.SERVER_USER, AConstant.DEFAULT_MESSAGE, null);
        db.addMessage(message);

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        assertArrayEquals("addOneMessage", messages.toArray(new Message[0]), db.getMessageList().toArray(new Message[0]));
    }

    @Test
    public void delMessage() throws Exception {

        DefaultDb db = new DefaultDb();
        Message message = new Message(new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME), AConstant.SERVER_USER, AConstant.DEFAULT_MESSAGE, null);
        db.addMessage(message);

        db.delMessage(message);

        assertTrue(db.getMessageList().isEmpty());
    }
}