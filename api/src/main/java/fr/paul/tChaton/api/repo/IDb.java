package fr.paul.tChaton.api.repo;

import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public interface IDb {

    Logger LOGGER = LoggerFactory.getLogger(IDb.class);

    //USER
    boolean setDbUser();

    boolean addUser(User user);

    boolean upUser(User user);

    boolean delUser(User user);

    //MESSAGE
    boolean setDbMessage();

    boolean addMessage(Message message);

    boolean upMessage(Message message);

    boolean delMessage(Message message);


}
