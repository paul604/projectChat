package fr.paul.tChaton.api.repo;

import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;

import java.util.List;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public interface IDb {

    //USER
    boolean setDbUser();

    boolean addUser(User user);

    boolean upUser(User user);

    boolean delUser(User user);

    User getUserWithId(String id);

    //MESSAGE
    boolean setDbMessage();

    boolean addMessage(Message message);

    boolean upMessage(Message message);

    boolean delMessage(Message message);

    List<Message> getHistoryOf(String userId);


}
