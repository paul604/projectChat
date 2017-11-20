package fr.paul.tChaton.application.api;

import com.google.gson.GsonBuilder;
import fr.paul.tChaton.application.enf.BuilderStatus;
import fr.paul.tChaton.application.enf.Status;
import fr.paul.tChaton.Api.entity.Message;
import fr.paul.tChaton.marketing.service.conversation.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@Controller
@EnableAutoConfiguration
public class Conversation {

    private final static Logger LOGGER = LoggerFactory.getLogger(Conversation.class);

    private Chat chat = new Chat();

    @ResponseBody
    @GetMapping("conversation")
    public String conversation(String message) {
        return mkResponse(message,checkIfWellFormed(message));
    }

    private String mkResponse(String message, Status checkIfWellFormed) {
//        Message messageToService = mkMessage(message,checkIfWellFormed) ;
        GsonBuilder builder = new GsonBuilder();
        String res = builder.create().toJson(chat.serviceConversation(message));
        return res;
    }

//    private Message mkMessage(String message, Status checkIfWellFormed) {
//        return null;
//    }

    private Status checkIfWellFormed(String message) {
        LOGGER.info("message ==> " + message);
        return BuilderStatus.treat(message);
    }
}
