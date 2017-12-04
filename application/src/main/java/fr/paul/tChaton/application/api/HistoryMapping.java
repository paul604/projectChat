package fr.paul.tChaton.application.api;

import com.google.gson.GsonBuilder;
import fr.paul.tChaton.marketing.service.conversation.History;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@Controller
@EnableAutoConfiguration
public class HistoryMapping {

    @Resource
    private History history;

    @ResponseBody
    @GetMapping("history")
    public String history(String id) {
        return mkResponse(id);
    }

    private String mkResponse(String id) {
        GsonBuilder builder = new GsonBuilder();
        String res = builder.create().toJson(history.serviceConversation(id));
        return res;
    }
}
