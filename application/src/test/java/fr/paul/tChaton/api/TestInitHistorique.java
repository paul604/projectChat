package fr.paul.tChaton.api;

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
    public void startAConversationMustStartWithEmptyHistory() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/conversation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.history").isEmpty());
    }
    @Test
    public void startAConversationMustContainDefaultMessage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/conversation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Bonjour, que puis je faire pour vous !"));
    }
}
