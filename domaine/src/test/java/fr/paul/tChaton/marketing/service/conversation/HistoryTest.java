package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.exception.UserIdNotFound;
import fr.paul.tChaton.infra.db.DefaultDb;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class HistoryTest {

    public static void setUp(History history) {
        history.setDb(new DefaultDb());
    }

    @Test
    public void caseHistoryVoid() throws UserIdNotFound {
        History history = new History();
        setUp(history);

        assertTrue(history.serviceHistory(AConstant.DEFAULT_USER_ID).isEmpty());
    }

    @Test
    public void caseHistoryNotVoid() throws UserIdNotFound, InterruptedException {
        History history = new History();
        setUp(history);

        Message message1 = new Message(AConstant.DEFAULT_USER, null, "1", Calendar.getInstance());
        Thread.sleep(10);
        Message message2 = new Message(AConstant.DEFAULT_USER, null, "1", Calendar.getInstance());

        history.getDb().addMessage(message1);
        history.getDb().addMessage(message2);

        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        assertArrayEquals("testGetHistoryForDefaultUser", messages.toArray(new Message[0]), history.serviceHistory(AConstant.DEFAULT_USER_ID).getMessages().toArray(new Message[0]));
    }


    @Test(expected = UserIdNotFound.class)
    public void caseErrorId() throws UserIdNotFound {
        History history = new History();
        setUp(history);

        history.serviceHistory("error");
    }
}