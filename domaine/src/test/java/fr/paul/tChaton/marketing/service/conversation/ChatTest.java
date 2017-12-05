package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.api.exception.UserIdNotFound;
import fr.paul.tChaton.infra.db.DefaultDb;
import org.junit.Before;
import org.junit.Test;

import java.security.spec.InvalidParameterSpecException;
import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class ChatTest {

    public static void setUp(Chat chat) {
        chat.setDb(new DefaultDb());
        chat.getDb().addUser(new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME));
    }

    @Test
    public void caseMessageHello() throws ParseException, UserIdNotFound, InvalidParameterSpecException {
        Chat chat = new Chat();
        setUp(chat);
        Message messageFromService  = chat.serviceConversation(AConstant.MESSAGE_HELLO, AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_CREATION_DATE);
        assertNotNull(messageFromService);
        assertEquals(AConstant.MESSAGE_HELLO, messageFromService.getMessage());

    }

    @Test
    public void caseMessageVoid() throws ParseException, UserIdNotFound, InvalidParameterSpecException {
        Chat chat = new Chat();
        setUp(chat);
        Message messageFromService  = chat.serviceConversation("", AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_CREATION_DATE);
        assertNotNull(messageFromService);
        assertEquals(AConstant.DEFAULT_MESSAGE, messageFromService.getMessage());

    }
}