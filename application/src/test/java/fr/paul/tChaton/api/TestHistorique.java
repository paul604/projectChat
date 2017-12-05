package fr.paul.tChaton.api;

import com.google.gson.GsonBuilder;
import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.application.api.HistoryMapping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HistoryMapping.class)
@ComponentScan(basePackages = "fr.paul.tChaton")
@AutoConfigureMockMvc
public class TestHistorique {

    @Autowired
    private MockMvc mvc;

    @Test
    public void startAConversationMustStartWhitEmptyHistory() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/history").param("id", AConstant.DEFAULT_USER_ID))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").isEmpty());
    }

    @Test
    public void getHistoryWithEmptyParam() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/history"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").isEmpty());
    }

    @Test
    public void checkSizeHistoryAfterTwoMessage() throws Exception {

        User user = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(user, AConstant.SERVER_USER, "first", Calendar.getInstance()));
        messageList.add(new Message(user, AConstant.SERVER_USER, "second", Calendar.getInstance()));

        GsonBuilder gsonBuilder = new GsonBuilder();

        mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message","first"));
        mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message","second"));

        mvc.perform(MockMvcRequestBuilders.get("/history").param("message","second"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(gsonBuilder.create().toJson(messageList).toString()));

    }
}
