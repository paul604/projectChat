package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.Api.factory.IFactory;
import fr.paul.tChaton.Api.repo.IRepo;
import fr.paul.tChaton.domain.entity.Message;

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
    public Message serviceConversation(Exception exception) {
        return new Message(exception);
    }
    public Message serviceConversation(Message messageToService) {
        Message res = null;
        if(messageToService == null || messageToService.isEmpty()){
            res = beginConversation();
        }else{
            res = treatmentMessage(messageToService);
        }
        return res;
    }
    private Message treatmentMessage(Message messageToService) {
        return null;
    }

}
