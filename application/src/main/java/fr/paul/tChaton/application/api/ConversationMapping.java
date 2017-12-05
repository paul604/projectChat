package fr.paul.tChaton.application.api;

import com.google.gson.GsonBuilder;
import fr.paul.tChaton.api.exception.UserIdNotFound;
import fr.paul.tChaton.marketing.service.conversation.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.spec.InvalidParameterSpecException;
import java.text.ParseException;
import java.util.Arrays;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@Controller
@EnableAutoConfiguration
public class ConversationMapping {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConversationMapping.class);

    @Resource
    private Chat chat;

    @ResponseBody
    @GetMapping("conversation")
    public ResponseEntity conversation(String message, String id, String creationDate) {
        return mkResponse(message, id, creationDate);
    }

    private ResponseEntity mkResponse(String message, String id, String creationDate) {
        GsonBuilder builder = new GsonBuilder();
        ResponseEntity res = null;
        try {
            res = ResponseEntity.ok(builder.create().toJson(chat.serviceConversation(message, id, creationDate)));
        } catch (NumberFormatException | UserIdNotFound | ParseException | InvalidParameterSpecException e) {
            LOGGER.error(e.getLocalizedMessage());
            LOGGER.error(Arrays.stream(e.getStackTrace())
                    .map(stackTraceElement -> stackTraceElement.toString()+"\n")
                    .reduce((s, s2) -> s+s2)
                    .get());
            res = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return res;
    }
}
