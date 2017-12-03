package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.IConstant;
import fr.paul.tChaton.api.factory.IFactory;
import fr.paul.tChaton.api.repo.IRepo;
import fr.paul.tChaton.api.entity.Message;

import javax.annotation.Resource;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Chat {

    @Resource
    IFactory factoy;

    @Resource
    IRepo repository;

    private Message beginConversation() {
        return new Message();
    }

    public Message serviceConversation(Message messageToService) {
        return serviceConversation(messageToService.getMessage());
    }

    public Message serviceConversation(String messageToService) {
        Message res = null;
        if(messageToService == null || messageToService.isEmpty()){
            res = beginConversation();
        }else{
            res = treatmentMessage(messageToService);
        }
        return res;
    }

    private Message treatmentMessage(String messageToService) {
        Message res =null;
        if(messageToService.contentEquals(IConstant.MESSAGE_HELLO)){
            res = new Message(IConstant.MESSAGE_HELLO, null);
        }
        return res;
    }

}
