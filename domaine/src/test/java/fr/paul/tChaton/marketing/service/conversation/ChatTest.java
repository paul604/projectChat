package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.Api.entity.IConstant;
import fr.paul.tChaton.Api.entity.Message;
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
        Message messageFromService  = chat.serviceConversation(IConstant.MESSAGE_HELLO);
        assertNotNull(messageFromService);
        assertEquals(IConstant.MESSAGE_HELLO,messageFromService.getMessage());

    }
}