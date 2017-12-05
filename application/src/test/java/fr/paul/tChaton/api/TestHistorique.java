package fr.paul.tChaton.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.History;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

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
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void checkSizeHistoryAfterTwoMessage() throws Exception {

        User user = AConstant.DEFAULT_USER;


        DateFormat df = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss");
        Calendar cal  = Calendar.getInstance();
        cal.setTime(df.parse(AConstant.DEFAULT_CREATION_DATE));
        Calendar cal2  = Calendar.getInstance();
        cal2.setTime(df.parse(AConstant.DEFAULT_CREATION_DATE2));

        List<Message> messageList = new ArrayList<>();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = new Gson();

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/conversation").param("message", "first")
                .param("id", AConstant.DEFAULT_USER_ID)
                .param("creationDate", AConstant.DEFAULT_CREATION_DATE))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Message message1Ret = gson.fromJson(content, Message.class);

        messageList.add(new Message(user, AConstant.SERVER_USER, "first", cal));
        messageList.add(message1Ret);


        Thread.sleep(1000);

        MvcResult result2 = mvc.perform(MockMvcRequestBuilders.get("/conversation")
                .param("message", "second")
                .param("id", AConstant.DEFAULT_USER_ID)
                .param("creationDate", AConstant.DEFAULT_CREATION_DATE2))
                .andReturn();
        String content2 = result2.getResponse().getContentAsString();
        Message message2Ret = gson.fromJson(content2, Message.class);

        messageList.add(new Message(user, AConstant.SERVER_USER, "second", cal2));
        messageList.add(message2Ret);

        MvcResult resultFin = mvc.perform(MockMvcRequestBuilders.get("/history").param("id", AConstant.DEFAULT_USER_ID)).andReturn();
//                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(gsonBuilder.create().toJson(messageList)));

        String contentAsString = resultFin.getResponse().getContentAsString();
        History historyResult = gson.fromJson(contentAsString, History.class);

        assertEquals("checkSizeHistoryAfterTwoMessage", messageList.size(), historyResult.getMessages().size());

    }
}
