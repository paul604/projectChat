package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.factory.IFactory;
import fr.paul.tChaton.api.repo.IDb;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.infra.factory.DbFactory;

import javax.annotation.Resource;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Chat {

    @Resource
    private IDb db;

    private Message beginConversation() {
        return new Message();
    }

    public Message serviceConversation(Message messageToService, String id) {
        return serviceConversation(messageToService.getMessage(), id);
    }

    public Message serviceConversation(String messageToService, String idString) {
        Message res = null;

        int id = Integer.parseInt(idString);

        if(messageToService == null || messageToService.isEmpty()){
            res = beginConversation();
        }else{
            res = treatmentMessage(messageToService);
        }
        return res;
    }

    private Message treatmentMessage(String messageToService) {
        Message res =null;
        if(messageToService.contentEquals(AConstant.MESSAGE_HELLO)){
            res = new Message(AConstant.MESSAGE_HELLO, null);
        }
        return res;
    }

}
