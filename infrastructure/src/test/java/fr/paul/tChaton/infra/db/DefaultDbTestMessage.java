package fr.paul.tChaton.infra.db;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class DefaultDbTestMessage {

    @Test
    public void addOneMessage() throws Exception {
        DefaultDb db = new DefaultDb();
        Message message = new Message(AConstant.DEFAULT_MESSAGE, null);
        db.addMessage(message);

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        assertArrayEquals("addOneMessage", messages.toArray(new Message[0]), db.getMessageList().toArray(new Message[0]));
    }
}