package fr.paul.tChaton.api;

import com.google.gson.GsonBuilder;
import fr.paul.tChaton.api.entity.IConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.application.api.Conversation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Conversation.class)
@AutoConfigureMockMvc
public class TestInitHistorique {

    @Autowired
    private MockMvc mvc;


    @Test
    public void startAConversationWithNoMessage() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/conversation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(IConstant.DEFAULT_MESSAGE));

    }

    @Test
    public void startAConversationMustStartWhitEmptyHistory() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/conversation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.history").isEmpty());

    }

    @Test
    public void startAConversationWithHello() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message",IConstant.MESSAGE_HELLO))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(IConstant.MESSAGE_HELLO));

    }

    @Test
    public void checkSizeHistoryAfterTwoMessage() throws Exception {

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message("first"));
        messageList.add(new Message("second"));

        GsonBuilder gsonBuilder = new GsonBuilder();


        mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message","first"));
        mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message","second"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.history").value(gsonBuilder.create().toJson(messageList).toString()));

    }
}
