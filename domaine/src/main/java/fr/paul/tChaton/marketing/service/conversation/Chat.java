package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.api.exception.UserIdNotFound;
import fr.paul.tChaton.api.factory.IFactory;
import fr.paul.tChaton.api.repo.IDb;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.infra.factory.DbFactory;

import javax.annotation.Resource;
import java.security.spec.InvalidParameterSpecException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class Chat {

    @Resource
    private IDb db;

    private Message beginConversation(User user) {
        return new Message(user);
    }

    public Message serviceConversation(Message messageToService){
        Message res = null;

        db.addMessage(messageToService);

        if(messageToService == null || messageToService.getMessage().equalsIgnoreCase("")){
            res = beginConversation(messageToService.getFrom());
        }else{
            res = treatmentMessage(messageToService.getMessage());
        }
        return res;
    }

    public Message serviceConversation(String messageToService, String idString, String creationDate) throws UserIdNotFound, ParseException, InvalidParameterSpecException {

        User user = db.getUserWithId(idString);
        if (user == null){
            throw new UserIdNotFound(idString+" non valid");
        }

        if (creationDate==null || creationDate.equalsIgnoreCase("")){
            throw new InvalidParameterSpecException("creation Date not null");
        }
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal  = Calendar.getInstance();
        cal.setTime(df.parse(creationDate));

        return serviceConversation(new Message(user, messageToService, cal));
    }

    private Message treatmentMessage(String messageToService) {
        Message res =null;
        if(messageToService.contentEquals(AConstant.MESSAGE_HELLO)){
            res = new Message(new User(AConstant.SERVER_USER_ID, AConstant.SERVER_USER_NAME), AConstant.MESSAGE_HELLO, Calendar.getInstance());
        }
        return res;
    }


    public IDb getDb() {
        return db;
    }

    public void setDb(IDb db) {
        this.db = db;
    }
}
