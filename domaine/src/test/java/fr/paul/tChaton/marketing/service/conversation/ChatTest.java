package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class ChatTest {

    @Test
    public void caseMessageHello(){
        Chat chat = new Chat();
        Message messageFromService  = chat.serviceConversation(AConstant.MESSAGE_HELLO, AConstant.DEFAULT_USER_ID);
        assertNotNull(messageFromService);
        assertEquals(AConstant.MESSAGE_HELLO, messageFromService.getMessage());

    }

    @Test
    public void caseMessageVoid(){
        Chat chat = new Chat();
        Message messageFromService  = chat.serviceConversation("", AConstant.DEFAULT_USER_ID);
        assertNotNull(messageFromService);
        assertEquals(AConstant.DEFAULT_MESSAGE, messageFromService.getMessage());

    }
}