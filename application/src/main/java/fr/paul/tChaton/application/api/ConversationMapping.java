package fr.paul.tChaton.application.api;

import com.google.gson.GsonBuilder;
import fr.paul.tChaton.marketing.service.conversation.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
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
public class ConversationMapping {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConversationMapping.class);

    private Chat chat = new Chat();

    @ResponseBody
    @GetMapping("conversation")
    public ResponseEntity conversation(String message) {
        return mkResponse(message);
    }

    private ResponseEntity mkResponse(String message) {
        GsonBuilder builder = new GsonBuilder();
        String res = builder.create().toJson(chat.serviceConversation(message));
//        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok(res);
    }
}
